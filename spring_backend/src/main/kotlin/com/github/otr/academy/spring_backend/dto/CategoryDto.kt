package com.github.otr.academy.spring_backend.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

import java.io.Serializable

/**
 *
 */
class CategoryDto(

    @JsonProperty("id")
    val id: Int,

    @JsonProperty("title")
    val title: String,

    @JsonIgnore
    @JsonProperty("description")
    val description: String

): Serializable
