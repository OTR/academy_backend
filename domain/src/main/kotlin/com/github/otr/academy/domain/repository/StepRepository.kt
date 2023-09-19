package com.github.otr.academy.domain.repository

import com.github.otr.academy.domain.model.Step

/**
 * If it's `theory` step, it is usually has a few `practice` steps
 * belong to it
 */
interface StepRepository : GenericRepository<Step> {

    fun getAllTheoryStepsIds(): List<Int>

    fun getAllPracticeSteps(): List<Step>

    fun getAllPracticeStepsIds(): List<Int>

}
