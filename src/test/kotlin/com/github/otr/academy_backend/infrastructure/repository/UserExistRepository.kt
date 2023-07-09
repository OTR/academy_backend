package com.github.otr.academy_backend.infrastructure.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.jdbc.core.JdbcTemplate

/**
 *
 */
interface UserExistInterface {
    fun isUserExist(name: String): Boolean
}

/**
 *
 */
@Repository
class UserExistRepository: UserExistInterface {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    override fun isUserExist(name: String): Boolean {
        val sql: String = "SELECT count(*) FROM Profile WHERE username = ?;"
        val count = jdbcTemplate.queryForObject(sql, Int::class.java, name)
        return count != 0
    }

}
