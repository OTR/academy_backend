package com.github.otr.academy.scraper.dto.category

import com.google.gson.annotations.SerializedName

/**
 *
 */
data class CategoriesDTO(

    @SerializedName("track-categories")
    var listOfCategories: ArrayList<CategoryDTO>

)
