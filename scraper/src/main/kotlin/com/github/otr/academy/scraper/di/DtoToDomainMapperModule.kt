package di

import dagger.Binds
import dagger.Module

import data.mapper.dto_to_domain.AttemptDtoToDomainMapperImpl
import data.mapper.dto_to_domain.GenericDtoToDomainMapper
import data.mapper.dto_to_domain.ProjectDtoToDomainMapperImpl
import data.mapper.dto_to_domain.StageDtoToDomainMapperImpl
import data.mapper.dto_to_domain.StepDtoToDomainMapperImpl
import data.mapper.dto_to_domain.TopicDtoToDomainMapperImpl
import data.mapper.dto_to_domain.TrackDtoToDomainMapperImpl

import data.scraper.dto.attempt.AttemptDTO
import data.scraper.dto.project.ProjectDTO
import data.scraper.dto.stage.StageDTO
import data.scraper.dto.step.StepDTO
import data.scraper.dto.topic.TopicDTO
import data.scraper.dto.track.TrackDTO

import domain.model.Attempt

/**
 *
 */
@Module
interface DtoToDomainMapperModule {

    @Binds
    fun bindAttemptDtoToDomainMapper(
        impl: AttemptDtoToDomainMapperImpl
    ): GenericDtoToDomainMapper<Attempt, AttemptDTO>

    @Binds
    fun bindProjectDtoToDomainMapper(
        impl: ProjectDtoToDomainMapperImpl
    ): GenericDtoToDomainMapper<Project, ProjectDTO>

    @Binds
    fun bindStageDtoToDomainMapper(
        impl: StageDtoToDomainMapperImpl
    ): GenericDtoToDomainMapper<Stage, StageDTO>

    @Binds
    fun bindStepDtoToDomainMapper(
        impl: StepDtoToDomainMapperImpl
    ): GenericDtoToDomainMapper<Step, StepDTO>

    @Binds
    fun bindTopicDtoToDomainMapper(
        impl: TopicDtoToDomainMapperImpl
    ): GenericDtoToDomainMapper<Topic, TopicDTO>

    @Binds
    fun bindTrackDtoToDomainMapper(
        impl: TrackDtoToDomainMapperImpl
    ): GenericDtoToDomainMapper<Track, TrackDTO>

}
