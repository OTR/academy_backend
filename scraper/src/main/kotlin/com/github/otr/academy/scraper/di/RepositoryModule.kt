package di

import dagger.Binds
import dagger.Module

import data.repository.AttemptRepositoryImpl
import data.repository.CategoryRepositoryImpl
import data.repository.ProjectRepositoryImpl
import data.repository.StageRepositoryImpl
import data.repository.StepRepositoryImpl
import data.repository.TopicRepositoryImpl
import data.repository.TrackRepositoryImpl

import domain.model.Attempt

import domain.repository.GenericRepository
import domain.repository.StepRepository

/**
 *
 */
@Module
interface RepositoryModule {

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
