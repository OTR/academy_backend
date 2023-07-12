plugins {
    kotlin("kapt")
    application
}

kapt {
    generateStubs = true
}

dependencies {
    implementation(project(":domain"))

    implementation ("com.google.dagger:dagger:2.46.1")
    kapt ("com.google.dagger:dagger-compiler:2.46.1")
}

application {
    mainClass.set("MainKt")
}

//tasks.jar {
//    manifest {
//        attributes["Main-Class"] = "MainKt"
//    }
//    configurations["compileClasspath"].forEach { file: File ->
//        from(zipTree(file.absoluteFile))
//    }
//}