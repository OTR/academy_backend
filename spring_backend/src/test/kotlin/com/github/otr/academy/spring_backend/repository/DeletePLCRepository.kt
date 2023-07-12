package com.github.otr.academy.spring_backend.repository

import org.springframework.stereotype.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate

/**
 *
 */
interface DeletePLCByIDInterface {

    fun deleteAllUsersInfoByUserId(userId: Long): String

}

/**
 * Delete PLC means deleteById all the posts, likes and comments
 * that belong to a particular profile (user)
 */
@Repository
class DeletePLCRepository: DeletePLCByIDInterface {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun deleteAllUsersInfoByUserId(userId: Long): String {
        val deletePosts: String = "DELETE FROM Post WHERE profile_id = ?;"
        val deleteLikes: String = "DELETE FROM LikeObj WHERE profile_id = ?;"
        val deleteComments: String = "DELETE FROM Comment WHERE profile_id = ?;"

        jdbcTemplate.update(deletePosts, userId)
        jdbcTemplate.update(deleteLikes, userId)
        jdbcTemplate.update(deleteComments, userId)

        return "Deleting is done"
    }

}
