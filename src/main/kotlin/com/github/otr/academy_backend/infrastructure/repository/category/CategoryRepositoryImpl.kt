package com.github.otr.academy_backend.infrastructure.repository.category

import com.github.otr.academy_backend.domain.model.Category
import com.github.otr.academy_backend.domain.repository.CategoryRepository
import com.github.otr.academy_backend.infrastructure.mapper.CategoryMapper

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class CategoryRepositoryImpl(
    private val repository: JpaCategoryRepository,
    private val mapper: CategoryMapper
): CategoryRepository {

    override fun getAll(): List<Category> {
        return repository.findAll().map {
            mapper.mapDboToDomain(it)
        }
    }

    override fun getById(id: Int): Category {
        return repository.findById(id).orElseThrow().let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun create(entity: Category): Category {
        return repository.save(mapper.mapDomainToDbo(entity)).let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun update(entity: Category): Category {
        TODO()
    }

    override fun deleteById(id: Int) {
        repository.deleteById(id)
    }

}
