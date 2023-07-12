package com.github.otr.academy.spring_backend.config

import com.github.otr.academy.domain.repository.CategoryRepository
import com.github.otr.academy.domain.repository.ProjectRepository
import com.github.otr.academy.domain.repository.StageRepository
import com.github.otr.academy.domain.repository.TopicRepository
import com.github.otr.academy.domain.repository.TrackRepository
import com.github.otr.academy.domain.repository.UserRepository

import com.github.otr.academy.domain.use_case.category.GetAllCategoriesUseCase
import com.github.otr.academy.domain.use_case.category.GetTracksByCategoryIdUseCase
import com.github.otr.academy.domain.use_case.project.GetProjectDetailsByIdUseCase
import com.github.otr.academy.domain.use_case.stage.GetStagesByProjectIdUseCase
import com.github.otr.academy.domain.use_case.topic.GetTopicsForStageByIdUseCase
import com.github.otr.academy.domain.use_case.track.GetProjectsByLevelByTrackIdUseCase
import com.github.otr.academy.domain.use_case.track.GetTrackDetailsByIdUseCase
import com.github.otr.academy.domain.use_case.user.CreateUserUseCase
import com.github.otr.academy.domain.use_case.user.GetAllUsersUseCase

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Register Use Cases from domain layer as @Beans
 * to provide Service implementations for Spring Boot Framework
 */
@Configuration
class ServiceConfig {

    @Bean
    fun getAllCategoriesUseCase(repository: CategoryRepository): GetAllCategoriesUseCase {
        return GetAllCategoriesUseCase(repository)
    }

    @Bean
    fun getTracksByCategoryIdUseCase(repository: CategoryRepository): GetTracksByCategoryIdUseCase {
        return GetTracksByCategoryIdUseCase(repository)
    }

    @Bean
    fun getProjectDetailsByIdUseCase(repository: ProjectRepository): GetProjectDetailsByIdUseCase {
        return GetProjectDetailsByIdUseCase(repository)
    }

    @Bean
    fun getStagesByProjectIdUseCase(repository: StageRepository): GetStagesByProjectIdUseCase {
        return GetStagesByProjectIdUseCase(repository)
    }

    @Bean
    fun getTopicsForStageByIdUseCase(repository: TopicRepository): GetTopicsForStageByIdUseCase {
        return GetTopicsForStageByIdUseCase(repository)
    }

    @Bean
    fun getProjectsByLevelByTrackIdUseCase(
        repository: TrackRepository
    ): GetProjectsByLevelByTrackIdUseCase {
        return GetProjectsByLevelByTrackIdUseCase(repository)
    }

    @Bean
    fun getTrackDetailsByIdUseCase(repository: TrackRepository): GetTrackDetailsByIdUseCase {
        return GetTrackDetailsByIdUseCase(repository)
    }

    @Bean
    fun createUserUseCase(repository: UserRepository): CreateUserUseCase {
        return CreateUserUseCase(repository)
    }

    @Bean
    fun getAllUsersUseCase(repository: UserRepository): GetAllUsersUseCase {
        return GetAllUsersUseCase(repository)
    }

}
