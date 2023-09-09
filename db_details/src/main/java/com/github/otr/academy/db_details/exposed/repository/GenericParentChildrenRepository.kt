package com.github.otr.academy.db_details.exposed.repository

import com.github.otr.academy.domain.model.Project
import com.github.otr.academy.domain.model.Stage

interface GenericParentChildrenRepository<T, U> {

    fun getChildrenByParent(parent: Project): List<Stage>
}
