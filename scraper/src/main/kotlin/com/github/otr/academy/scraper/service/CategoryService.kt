package com.github.otr.academy.scraper.service

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.use_case.category.GetAllCategoriesUseCase

import javax.inject.Inject

/**
 *
 */
class CategoryService @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) {

    fun getAllCategories(): List<Category> {
        return getAllCategoriesUseCase.invoke()
    }

}
