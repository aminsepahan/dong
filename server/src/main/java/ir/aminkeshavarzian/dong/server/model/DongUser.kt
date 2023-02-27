package ir.aminkeshavarzian.dong.server.model

import org.jetbrains.exposed.sql.*

data class DongUser(val id: Int, val name: String, val bankCard: String, val email: String, val image: String?, val phoneNumber: String)

object DongUsers : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar(name = "title", length = 128)
    val email = varchar(name = "email", length = 128)
    val image = varchar(name = "image", length = 256)
    val bankCard = varchar(name = "bank_card", length = 16)
    val phoneNumber = varchar(name = "phone_number", length = 32)
    override val primaryKey = PrimaryKey(id)
}