plugins {
    kotlin("kapt")
}

kapt {
    generateStubs = true
}

dependencies {
    
    implementation(project(":domain"))

    // Exposed ORM framework
    implementation("org.jetbrains.exposed", "exposed-core", "0.40.1")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.40.1")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.40.1")

    // Dagger 2
    implementation ("com.google.dagger:dagger:2.46.1")
    kapt ("com.google.dagger:dagger-compiler:2.46.1")

    // SQLite Driver
    implementation("org.xerial:sqlite-jdbc:3.42.0.0")

}
