package com.github.otr.academy.scraper.di

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage

import dagger.Binds
import dagger.Module

/**
 *
 */
@Module
internal interface ParentChildrenRepositoryModule {

    @Binds
    fun bindProjectToStageRepository(
        impl: StageRepositoryImpl
    ): GenericParentChildrenRepository<Project, Stage>

}
