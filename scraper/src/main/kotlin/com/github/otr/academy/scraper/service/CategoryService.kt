package presentation.service

import domain.use_case.category.GetAllCategoriesUseCase

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
