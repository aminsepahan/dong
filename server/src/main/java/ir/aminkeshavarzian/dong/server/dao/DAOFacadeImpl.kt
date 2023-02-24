package ir.aminkeshavarzian.dong.server.dao

import ir.aminkeshavarzian.dong.server.dao.DatabaseFactory.dbQuery
import ir.aminkeshavarzian.dong.server.model.DongUser
import ir.aminkeshavarzian.dong.server.model.DongUsers
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class DAOFacadeImpl : DAOFacade {

    private fun resultRowToDongUser(row: ResultRow) = DongUser(
        id = row[DongUsers.id],
        name = row[DongUsers.name],
        email = row[DongUsers.email],
        bankCard = row[DongUsers.bankCard],
        image = row[DongUsers.image],
    )

    override suspend fun allUsers(): List<DongUser> = dbQuery {
        DongUsers.selectAll().map(::resultRowToDongUser)
    }

    override suspend fun addUser(
        name: String,
        email: String,
        bankCard: Int,
        image: String
    ): DongUser? = dbQuery {
        val insertStatement = DongUsers.insert {
            it[DongUsers.name] = name
            it[DongUsers.email] = email
            it[DongUsers.bankCard] = bankCard
            it[DongUsers.image] = image
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToDongUser)
    }
}

val dao: DAOFacade = DAOFacadeImpl()

