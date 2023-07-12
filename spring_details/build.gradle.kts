plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.jpa") version "1.8.22"
}

dependencies {

    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
//    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")

//    runtimeOnly("com.h2database:h2")

//    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

// Social network
// runtimeOnly("com.mysql:mysql-connector-j")

// the new boston
// testImplementation("io.mockk:mockk:1.13.4")
