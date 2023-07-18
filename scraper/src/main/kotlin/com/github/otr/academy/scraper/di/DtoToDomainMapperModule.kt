package com.github.otr.academy.scraper.di

import com.github.otr.academy.domain.model.Attempt
import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage
import com.github.otr.academy.domain.model.Step
import com.github.otr.academy.domain.model.Topic
import com.github.otr.academy.domain.model.Track

import com.github.otr.academy.scraper.dto.attempt.AttemptDTO
import com.github.otr.academy.scraper.dto.project.ProjectDTO
import com.github.otr.academy.scraper.dto.stage.StageDTO
import com.github.otr.academy.scraper.dto.step.StepDTO
import com.github.otr.academy.scraper.dto.topic.TopicDTO
import com.github.otr.academy.scraper.dto.track.TrackDTO

import com.github.otr.academy.scraper.mapper.AttemptMapper
import com.github.otr.academy.scraper.mapper.GenericDtoMapper
import com.github.otr.academy.scraper.mapper.ProjectMapper
import com.github.otr.academy.scraper.mapper.StageMapper
import com.github.otr.academy.scraper.mapper.StepMapper
import com.github.otr.academy.scraper.mapper.TopicMapper
import com.github.otr.academy.scraper.mapper.TrackMapper

import dagger.Binds
import dagger.Module

/**
 *
 */
@Module
internal interface DtoToDomainMapperModule {

    @Binds
    fun bindAttemptDtoToDomainMapper(
        impl: AttemptMapper
    ): GenericDtoMapper<Attempt, AttemptDTO>

    @Binds
    fun bindProjectDtoToDomainMapper(
        impl: ProjectMapper
    ): GenericDtoMapper<Project, ProjectDTO>

    @Binds
    fun bindStageDtoToDomainMapper(
        impl: StageMapper
    ): GenericDtoMapper<Stage, StageDTO>

    @Binds
    fun bindStepDtoToDomainMapper(
        impl: StepMapper
    ): GenericDtoMapper<Step, StepDTO>

    @Binds
    fun bindTopicDtoToDomainMapper(
        impl: TopicMapper
    ): GenericDtoMapper<Topic, TopicDTO>

    @Binds
    fun bindTrackDtoToDomainMapper(
        impl: TrackMapper
    ): GenericDtoMapper<Track, TrackDTO>

}
