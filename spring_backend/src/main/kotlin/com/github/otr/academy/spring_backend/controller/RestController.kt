package com.github.otr.academy.spring_backend.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.repository.CategoryRepository

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import java.io.Serializable

/**
 *  * GET /api/track-categories return all categories
 *  * GET /api/track-categories/{id} return a category by the given ID
 *  * POST /api/track-categories/new create a new category with fields supplied as JSON in request body
 *  * PUT /api/track-categories/{id} update a category by the given ID with fields supplied as JSON
 *                in request body
 *  * DELETE /api/track-categories/{id} delete a category by the given ID
 */
@RestController
class RestCategoryController(
    private val repository: CategoryRepository,
    private val objectMapper: ObjectMapper = jacksonObjectMapper()
) {

    companion object {
        private const val BASE_API_URL: String = "/api/track-categories"
    }

    @PostMapping(path = ["$BASE_API_URL/new"])
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewCategory(@RequestBody newEntity: Category): Category {
        return repository.create(newEntity)
    }

    @GetMapping(path = [BASE_API_URL])
    fun getAllCategories(): List<Category> {
        return repository.getAll()
    }

    @GetMapping(path = ["$BASE_API_URL/{id}"])
    fun getCategoryById(@PathVariable("id") id: Int): ResponseEntity<Serializable> {
        val retrievedCategory = repository.getById(id)
        return if(retrievedCategory == null) {
            ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(toJson("Text Entity with ID: $id not found"))
        } else {
            ResponseEntity
                .ok()
                .body(toJson(retrievedCategory))
        }
    }

    @PutMapping(path = ["$BASE_API_URL/{id}"])
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateTextEntityById(
        @PathVariable("id") id: Int,
        @RequestBody updatedCategory: Category
    ): Category {
        return repository.update(updatedCategory)
    }

    @DeleteMapping(path = ["$BASE_API_URL/{id}"])
    fun deleteTextEntityById(@PathVariable("id") id: Int): ResponseEntity<String> {
        val retrievedTextEntity = repository.deleteById(id)
        return if (retrievedTextEntity == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                toJson("Text Entity with ID: $id not found")
            )
        } else {
            ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                toJson("Text Entity with ID: $id deleted")
            )
        }
    }


    /**
     * Serialize Any object to valid JSON
     */
    private fun toJson(value: Any): String {
        return objectMapper.writeValueAsString(value)
    }

}
