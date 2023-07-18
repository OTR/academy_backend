package di

import dagger.Binds
import dagger.Module
import data.repository.StageRepositoryImpl

import domain.repository.GenericParentChildrenRepository

/**
 *
 */
@Module
interface ParentChildrenRepositoryModule {

    @Binds
    fun bindProjectToStageRepository(
        impl: StageRepositoryImpl
    ): GenericParentChildrenRepository<Project, Stage>

}
