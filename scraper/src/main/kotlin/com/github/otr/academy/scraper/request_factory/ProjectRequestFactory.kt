package com.github.otr.academy.scraper.request_factory

import com.github.otr.academy.scraper.task.project.request.ProjectRequest
import com.github.otr.academy.scraper.task.project.request.ProjectRequestType

/**
 *
 */
internal object ProjectRequestFactory {

    fun getBlankProjectRequest(projectId: Int) = ProjectRequest(
        type = ProjectRequestType(projectId),
        pathToCacheFile = null,
        isCacheExists = null,
        sourceData = null,
        dto = null,
        isRowExists = null,
        entityFromDB = null
    )

}

/*

    // TODO: Remove custom constructor
    constructor(id: Int) : this(
        id = id,
        title = "",
        description = "",
        longDescription = "",
        environment = "",
        language = "",
        isBeta = false,
        isTemplateBased = false,
        useIde = false,
        isPublic = false,
        isIdeRequired = false,
        stagesCount = -1,
        stagesIds = emptyList(),
        readiness = -1
    )


 */