package ir.aminkeshavarzian.dong.server.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@Suppress("unused")
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello, World!!!!")
        }
        get("/welcome") {
            call.respondText("asdf2")
        }
        get("/welcome2") {
            call.respondText("asdf2")
        }
    }
}