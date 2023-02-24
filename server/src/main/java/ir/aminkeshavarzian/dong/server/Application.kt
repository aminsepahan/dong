package ir.aminkeshavarzian.dong.server

import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ir.aminkeshavarzian.dong.server.dao.DatabaseFactory
import ir.aminkeshavarzian.dong.server.plugins.configureKoin
import ir.aminkeshavarzian.dong.server.plugins.configureMonitoring
import ir.aminkeshavarzian.dong.server.plugins.configureRouting
import ir.aminkeshavarzian.dong.server.plugins.configureSerialization


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureKoin()
    DatabaseFactory.init()
    configureRouting()
    configureMonitoring()
    configureSerialization()
}