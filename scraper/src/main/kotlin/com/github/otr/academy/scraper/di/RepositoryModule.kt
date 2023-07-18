package com.github.otr.academy.scraper.di

import com.github.otr.academy.domain.model.Attempt
import com.github.otr.academy.domain.model.Category
import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.model.Topic
import com.github.otr.academy.domain.model.Track
import com.github.otr.academy.domain.repository.GenericRepository
import com.github.otr.academy.domain.repository.StepRepository

import dagger.Binds
import dagger.Module

/**
 *
 */
@Module
internal interface RepositoryModule {

    @Binds
    fun bindAttemptsRepository(
        impl: AttemptRepositoryImpl
    ): GenericRepository<Attempt>

    @Binds
    fun bindStepRepository(
        impl: StepRepositoryImpl
    ): StepRepository

    @Binds
    fun bindProjectRepository(
        impl: ProjectRepositoryImpl
    ): GenericRepository<Project>

    @Binds
    fun bindCategoryRepository(
        impl: CategoryRepositoryImpl
    ): GenericRepository<Category>

    @Binds
    fun bindStageRepository(
        impl: StageRepositoryImpl
    ): GenericRepository<Stage>

    @Binds
    fun bindTopicRepository(
        impl: TopicRepositoryImpl
    ): GenericRepository<Topic>

    @Binds
    fun bindTrackRepository(
        impl: TrackRepositoryImpl
    ): GenericRepository<Track>

}
