plugins {
    application
    id("kotlin-platform-jvm")
    id("org.jetbrains.kotlin.plugin.serialization")
}

group = "ir.aminkeshavarzian.dong.server"
version = "0.1"

repositories {
    mavenCentral()
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation("io.ktor:ktor-server-core:2.2.2")
    implementation("io.ktor:ktor-server-netty:2.2.2")
    implementation("ch.qos.logback:logback-classic:1.2.6")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")


    implementation(project(":common"))
}