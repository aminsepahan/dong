package ir.aminkeshavarzian.dong.server.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

@Suppress("unused")
fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
    }
}