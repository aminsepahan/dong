package ir.aminkeshavarzian.dong.server

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    routing {
        get("/dong") {
            call.respondText("Hello, World!")
        }
    }
}