package ir.aminkeshavarzian.dong.server.model

import org.jetbrains.exposed.sql.*

data class DongUser(val id: Int, val name: String, val bankCard: Int, val email: String, val image: String)

object DongUsers : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("title", 128)
    val email = varchar("email", 128)
    val image = varchar("image", 256)
    val bankCard = integer("bank_card")

    override val primaryKey = PrimaryKey(id)
}