val koinKtorVersion: String by project
val ktorVersion: String by project
val exposedVersion: String by project
val h2Version: String by project

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

    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-server-call-logging:$ktorVersion")
    implementation("io.ktor:ktor-server-tests:2.2.2")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("org.jetbrains.kotlin:kotlin-test:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation("io.insert-koin:koin-ktor:$koinKtorVersion")
    implementation("io.insert-koin:koin-logger-slf4j:$koinKtorVersion")

    //database
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("com.h2database:h2:$h2Version")


    implementation(project(":common"))
}