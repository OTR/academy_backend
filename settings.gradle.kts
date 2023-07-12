pluginManagement {

	repositories {
		maven { url = uri("https://repo.spring.io/milestone") }
		maven { url = uri("https://repo.spring.io/snapshot") }
		gradlePluginPortal()
        mavenCentral()
	}

}

rootProject.name = "academy_backend"
include(":core")
include(":spring_backend")
include(":scraper")
