package com.github.otr.academy_backend.infrastructure.controller

import com.github.otr.academy_backend.domain.model.User
import com.github.otr.academy_backend.infrastructure.controller.form.CreateUserDataForm
import com.github.otr.academy_backend.infrastructure.mapper.user.UserMapper
import com.github.otr.academy_backend.use_case.user.CreateUserUseCase

import org.springframework.core.env.Environment
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

/**
 *
 */
@Controller
class HtmlUserController(
    private val environment: Environment,
    private val createUserUseCase: CreateUserUseCase
) {

    private val mapper: UserMapper = UserMapper()

    companion object {
        private const val NEW_PROFILE_PATH: String = "/profile/new"
        private const val ADD_EDIT_TEMPLATE_NAME: String = "user/add_edit_user"
        private const val DEFAULT_TITLE: String = "Default Title"
        private const val PROFILE_TITLE_KEY: String = "title.profile"
    }

    @GetMapping(path = [NEW_PROFILE_PATH])
    fun getUserForm(model: Model): String {
        model["title"] = environment.getProperty(PROFILE_TITLE_KEY, DEFAULT_TITLE)
        model["user"] = CreateUserDataForm()
        return ADD_EDIT_TEMPLATE_NAME
    }

    @PostMapping(
        path = [NEW_PROFILE_PATH],
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE]
    )
    fun createNewUser(
        @ModelAttribute userDataForm: CreateUserDataForm
    ): String {
        mapper.mapDataFormToDomain(userDataForm)?.let { user: User ->
            createUserUseCase(user)
        }
        return "redirect:$NEW_PROFILE_PATH"
    }

}
