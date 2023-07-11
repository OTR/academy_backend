package com.github.otr.academy_backend.infrastructure.repository.project

import com.github.otr.academy_backend.domain.model.Project
import com.github.otr.academy_backend.domain.repository.ProjectRepository
import com.github.otr.academy_backend.infrastructure.mapper.project.ProjectMapper

import org.springframework.stereotype.Component

/**
 *
 */
@Component
class ProjectRepositoryImpl(
    private val repository: JpaProjectRepository,
    private val mapper: ProjectMapper
): ProjectRepository {

    override fun getAll(): List<Project> {
        return repository.findAll().map {
            mapper.mapDboToDomain(it)
        }
    }

    override fun getById(id: Int): Project {
        return repository.findById(id).orElseThrow().let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun create(entity: Project): Project {
        return repository.save(mapper.mapDomainToDbo(entity)).let {
            mapper.mapDboToDomain(it)
        }
    }

    override fun update(entity: Project): Project {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int) {
        repository.deleteById(id)
    }

}
