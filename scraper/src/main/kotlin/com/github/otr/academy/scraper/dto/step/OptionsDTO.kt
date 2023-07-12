package com.github.otr.academy.scraper.dto.step

import com.google.gson.annotations.SerializedName

/*

  @SerializedName("task_type"                         ) var taskType                      : String?          = null,
  @SerializedName("lesson_type"                       ) var lessonType                    : String?          = null,
  @SerializedName("title"                             ) var title                         : String?          = null,
  @SerializedName("description_text"                  ) var descriptionText               : String?          = null,
  @SerializedName("description_format"                ) var descriptionFormat             : String?          = null,
  @SerializedName("files"                             ) var files                         : ArrayList<Files> = arrayListOf(),
  @SerializedName("samples"                           ) var samples                       : String?          = null,
  @SerializedName("execution_memory_limit"            ) var executionMemoryLimit          : String?          = null,
  @SerializedName("execution_time_limit"              ) var executionTimeLimit            : String?          = null,
  @SerializedName("limits"                            ) var limits                        : String?          = null,
  @SerializedName("code_templates"                    ) var codeTemplates                 : String?          = null,
  @SerializedName("format_version"                    ) var formatVersion                 : Int?             = null,
  @SerializedName("custom_name"                       ) var customName                    : String?          = null,
  @SerializedName("solution_hidden"                   ) var solutionHidden                : String?          = null,
  @SerializedName("code_templates_header_lines_count" ) var codeTemplatesHeaderLinesCount : String?          = null,
  @SerializedName("code_templates_footer_lines_count" ) var codeTemplatesFooterLinesCount : String?          = null,
  @SerializedName("hyperskill"                        ) var hyperskill                    : Hyperskill?      = Hyperskill(),
  @SerializedName("language"                          ) var language                      : String?          = null


 */
data class OptionsDTO(

    @SerializedName("is_run_user_code_allowed")
    var isRunUserCodeAllowed: Boolean?,

    @SerializedName("language")
    var language: String?

)
