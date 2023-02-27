package ir.aminkeshavarzian.dong.server

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ir.aminkeshavarzian.dong.server.dao.DatabaseFactory
import ir.aminkeshavarzian.dong.server.plugins.*
import kotlinx.css.CssBuilder


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureKoin()
    DatabaseFactory.init()
    configureRouting()
    configureTemplating()
    configureMonitoring()
    configureSerialization()
}

suspend inline fun ApplicationCall.respondCss(builder: CssBuilder.() -> Unit) {
    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
