package ir.aminkeshavarzian.dong.server.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import ir.aminkeshavarzian.dong.server.dao.dao
import ir.aminkeshavarzian.dong.server.respondCss
import kotlinx.css.*
import kotlinx.css.Color.Companion.violet
import kotlinx.css.Color.Companion.white
import kotlinx.css.properties.*
import kotlinx.css.properties.IterationCount.Companion.infinite
import kotlinx.html.*
import java.util.Collections.rotate

@Suppress("unused")
fun Application.configureRouting() {
    routing {

        route("/dongusers") {
            get("/styles.css") {
                call.respondCss {
                    body {
                        background {
                            background = "url(\"banana_close.png\");"
                            backgroundRepeat = BackgroundRepeat.repeat
                        }
                        animation(duration = 15.s, iterationCount = infinite, name = "bg-animate")
                        animationTimingFunction = Timing.linear
                    }
                    rule("bodyBackground") {
                        borderRadius = 25.px
                        backgroundColor = violet
                        backgroundClip = BackgroundClip.borderBox
                    }
                }
            }
            get {
                call.respondHtml {
                    head {
                        link(rel = "stylesheet", href = "/styles.css", type = "text/css")
                    }
                    body {
                        h1(classes = "bodyBackground") {
                            +"Hello from Ktor!"
                        }
                    }
                }
//                call.respond(FreeMarkerContent("show_users.ftl", mapOf("users" to dao.allUsers())))
            }

            get("new") {
                call.respond(FreeMarkerContent("new_user.ftl", model = null))
            }

            get("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(
                    FreeMarkerContent(
                        template = "show_user.ftl",
                        model = mapOf("article" to dao.getUser(id))
                    )
                )
            }

            post {
                val formParameters = call.receiveParameters()
                val name = formParameters.getOrFail("name")
                val phone = formParameters.getOrFail("phone")
                val email = formParameters.getOrFail("email")
                val cardNumber = formParameters.getOrFail("card-number")

                try {
                    val user = dao.addUser(
                        name = name,
                        email = email,
                        bankCard = cardNumber,
                        phoneNumber = phone,
                    )
                    call.respondRedirect("/dongusers/${user?.id}")
                } catch (e: Exception) {
                    call.respondRedirect("/error/${e.localizedMessage}")
                }
            }

            get("{id}/edit") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                call.respond(FreeMarkerContent("edit_user.ftl", mapOf("user" to dao.getUser(id))))
            }


            post("{id}") {
                val id = call.parameters.getOrFail<Int>("id").toInt()
                val formParameters = call.receiveParameters()
                when (formParameters.getOrFail("_action")) {
                    "Save changes" -> {
                        val name = formParameters.getOrFail("name")
                        val phone = formParameters.getOrFail("phone")
                        val email = formParameters.getOrFail("email")
                        val cardNumber = formParameters.getOrFail("card-number")
                        dao.editUser(
                            id = id,
                            name = name,
                            email = email,
                            bankCard = cardNumber,
                            phoneNumber = phone,
                        )
                        call.respondRedirect("/dongusers/$id")
                    }
                    "delete" -> {
                        dao.deleteUser(id)
                        call.respondRedirect("/dongusers")
                    }
                }
            }
        }
        static(remotePath = "assets") {
            resources("static")
        }
        get {
            call.respondHtml {
                head {
                    link(rel = "stylesheet", href = "/styles.css", type = "text/css")
                }
                body {
                    h1(classes = "page-title") {
                        +"Hello from Ktor!"
                    }
                }
            }
        }
        get("/styles.css") {
            call.respondCss {
                body {
                    background = "url(\"/assets/banana_close.png\");"
                    backgroundRepeat = BackgroundRepeat.repeat
                    animation(duration = 15.s, iterationCount = infinite, name = "bg-animate"){
                        to {
                            transform {
                                rotate(360.deg)
                            }
                        }
                    }
                    animationTimingFunction = Timing.linear
                }
                rule("h1.page-title") {
                    color = Color.white
                }
            }
        }
//        get("/") {
//            call.respondRedirect("dongusers")
//        }
        route("/error") {
            get("{message}") {
                val errorMessage = call.parameters.getOrFail<String>("message")
                call.respond(FreeMarkerContent("error.ftl", mapOf("message" to errorMessage)))
            }
        }
    }
}