package ir.aminkeshavarzian.dong.server

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@Suppress("unused")
fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}