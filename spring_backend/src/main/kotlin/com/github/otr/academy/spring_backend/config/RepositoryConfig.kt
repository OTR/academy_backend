package com.github.otr.academy.spring_backend.config

import com.github.otr.academy.spring_details.database.jpa.config.JpaRepositoryConfig

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * Register Repository Implementations from module `spring_details` JPA as @Beans
 * to provide dependencies for Spring Boot Framework
 */
@Configuration
@Import(JpaRepositoryConfig::class)
class RepositoryConfig
