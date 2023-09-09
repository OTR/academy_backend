package com.github.otr.academy.domain.repository

import com.github.otr.academy.domain.model.Step

/**
 * TODO:
 */
interface StepRepository : GenericRepository<Step> {

    fun getAllTheoryStepsIds(): List<Int>

    fun getAllPracticeSteps(): List<Step>

    fun getAllPracticeStepsIds(): List<Int>

}
