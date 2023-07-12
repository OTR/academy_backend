plugins {
    kotlin("kapt")
    application
}

kapt {
    generateStubs = true
}

dependencies {
    implementation(project(":domain"))

    // Gson
    implementation("com.google.code.gson:gson:2.10.1")

    // Logback Classic SLF4J binding
    implementation("ch.qos.logback:logback-classic:1.3.6")

    // Dagger 2
    implementation ("com.google.dagger:dagger:2.46.1")
    kapt ("com.google.dagger:dagger-compiler:2.46.1")
}
