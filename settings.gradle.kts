pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        kotlin("multiplatform").version(extra["kotlinVersion"] as String)
        kotlin("android").version(extra["kotlinVersion"] as String)
        id("com.android.application").version(extra["agp.version"] as String)
        id("com.android.library").version(extra["agp.version"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
        id("org.jetbrains.kotlin.jvm") version "1.8.0"
    }
}

rootProject.name = "Dong"

include(":android", ":desktop", ":common", ":web")
include(":server")
