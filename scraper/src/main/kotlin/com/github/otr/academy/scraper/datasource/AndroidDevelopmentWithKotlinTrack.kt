package com.github.otr.academy.scraper.datasource

import com.github.otr.academy.domain.model.Track

private const val LONG_DESCRIPTION: String = """Android is an extremely popular platform controlling over 70% of mobile OS market. It’s free and open-source, with a new version packed with all the latest features released each year. Select this track if you have experience with Kotlin and want to learn how to work with Android Studio and develop compelling, professional-quality applications — a highly demanded skill across the globe. The track is developing fast, and new topics and projects are on their way.
You will discover how to:

  * create and run an app, either on an emulator or a real device;
  * design UIs;
  * store data locally or access it from remote sources;
  * build dynamic UIs and navigation graphs with Fragments;
  * use helpful tools like Java and Kotlin libraries;
  * work with professional development tools like Android studio.
  * Sounds exciting? Choose the Android track, and let's get started!"""

/**
 *
 */
@Deprecated("Was defined only for testing purposes")
internal val AndroidDevelopmentWithKotlinTrack = Track (
    id = 16,
    title = "Android Development with Kotlin",
//    projectsCount = 18,
    description = "You already know some Kotlin and want to try your hand at creating Android applications? Choose the Android Development with Kotlin track and start working with the most popular mobile OS platform in the world. The track will expose you to the thrilling world of Android applications, UIs, and development tools.",
    longDescription = LONG_DESCRIPTION,
//    easyProjects = listOf(Project(196), Project(126), Project(138), Project(300), Project(279), Project(123),),
//    mediumProjects = listOf(Project(158), Project(202), Project(177), Project(214), Project(222), Project(75)),
//    hardProjects = listOf(Project(190), Project(237), Project(83)),
//    challengingProjects = listOf(Project(276), Project(303), Project(198), Project(333), Project(241), Project(72), Project(289)),
//    betaProjects = listOf(),
//    capstoneProjects = listOf(), // TODO:

    isBeta = true,
    isFree = false,
    isPublic = false
)
