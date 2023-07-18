package data.scraper.datasource

/**
 * Hidden from any user Category that contains
 * alpha project that are in progress, accessible but not published yet
 * only reachable from API call
 */
val ALPHA_PROJECTS: List<Int> = listOf(
    306, // Rock-Paper-Scissors (Go) (Alpha)
    311, // Long Whale Ago (Bioinformatics) (Beta)
    320, // Postprocessor (Introduction to NodeJS) (Draft)
    340, // Cats and Dogs Classification with Pre-trained Neural Network (Machine Learning) (Beta)
    342, // Medical Geneticist Routine (Bioinformatics)
    345, // From Woof to SNP (Bioinformatics)
    346, // Run Docker Run (Introduction to Docker) (Beta)
    347, // Optimize Learning Path (Machine Learning) (Alpha)
    349, // Reminder Application (Java Developer) (Beta)
    353, // Simple Wallpaper Manager (Android Kotlin) (RecyclerView) (Alpha)
    354, // Random Forest From Scratch (Data Science) (Alpha)
    356, // HyperSearch Engine (Intro to Natural Language Processing) (Beta)
    359, // Who wants to be a Millionaire (JavaScript Developer) (Alpha)
    360, // Can you Transplant it? (Bioinformatics) (Alpha)
    361, // Principal Component Analysis with Pen and Paper (Data Science) (Alpha)
    362, // Site for Marathon (Frontend) (Alpha)
    363, // Battleship (Kotlin) (Alpha)
    364  // Bulls and Cows (Kotlin) (Alpha)
)
