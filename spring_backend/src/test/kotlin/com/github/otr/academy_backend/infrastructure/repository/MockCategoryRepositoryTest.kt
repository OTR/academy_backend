package com.github.otr.academy_backend.infrastructure.repository

import com.github.otr.academy_backend.domain.model.Category

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

/**
 *
 */
internal class MockCategoryRepositoryTest {

    private val mockCategoryRepository = MockCategoryRepositoryImpl()

    @Test
    fun `should provide a collection of categories`() {
        // when (act)
        val categories = mockCategoryRepository.getAll()
        // then (assert)
        assertThat(categories.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`() {
        // WHEN
        val categories: List<Category> = mockCategoryRepository.getAll()

        // THEN
        assertThat(categories).allMatch { it.title.isNotBlank() }
        assertThat(categories).anyMatch { it.description.isNotBlank() }
        assertThat(categories).anyMatch { it.id != 0 }
    }

}
