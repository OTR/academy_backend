package com.github.otr.academy.spring_backend.repository

import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.repository.GenericRepository

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

/**
 *
 */
@DataJpaTest
class SecondCategoryRepositoryTest {

    @Autowired
    private lateinit var entityManager: TestEntityManager

    @Autowired
    private lateinit var profileRepository: GenericRepository<Category>

    private fun getNewCategory(): Category {
        return Category(
            id = 1,
            title = "naruto",
            description = "123456"
        )
    }

    @Test
    fun getUserTesting() {
        val newCategory: Category = getNewCategory()
        val savedCategory: Category = entityManager.merge(newCategory)
        val foundCategory: Category = profileRepository.getById(savedCategory.id)

        assertThat(foundCategory.title).isEqualTo(savedCategory.title)
    }

}
