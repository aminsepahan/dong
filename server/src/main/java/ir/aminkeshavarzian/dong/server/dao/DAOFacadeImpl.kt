package ir.aminkeshavarzian.dong.server.dao

import ir.aminkeshavarzian.dong.server.dao.DatabaseFactory.dbQuery
import ir.aminkeshavarzian.dong.server.model.DongUser
import ir.aminkeshavarzian.dong.server.model.DongUsers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class DAOFacadeImpl : DAOFacade {

    private fun resultRowToDongUser(row: ResultRow) = DongUser(
        id = row[DongUsers.id],
        name = row[DongUsers.name],
        email = row[DongUsers.email],
        bankCard = row[DongUsers.bankCard],
        image = row[DongUsers.image],
        phoneNumber = row[DongUsers.phoneNumber]
    )

    override suspend fun allUsers(): List<DongUser> = dbQuery {
        DongUsers.selectAll().map(::resultRowToDongUser)
    }

    override suspend fun addUser(
        name: String,
        email: String,
        bankCard: String,
        phoneNumber: String
    ): DongUser? = dbQuery {
        val insertStatement = DongUsers.insert {
            it[DongUsers.name] = name
            it[DongUsers.email] = email
            it[DongUsers.bankCard] = bankCard
            it[DongUsers.phoneNumber] = phoneNumber
            it[DongUsers.image] = ""
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToDongUser)
    }

    override suspend fun editUser(
        id: Int,
        name: String,
        email: String,
        bankCard: String,
        phoneNumber: String
    ): Boolean = dbQuery {
        DongUsers.update({ DongUsers.id eq id }) {
            it[DongUsers.name] = name
            it[DongUsers.email] = email
            it[DongUsers.bankCard] = bankCard
            it[DongUsers.phoneNumber] = phoneNumber
        } > 0
    }

    override suspend fun deleteUser(id: Int): Boolean = dbQuery {
        DongUsers.deleteWhere { DongUsers.id eq id } > 0
    }

    override suspend fun getUser(id: Int): DongUser? = dbQuery {
        DongUsers.select { DongUsers.id eq id }
            .map(::resultRowToDongUser)
            .singleOrNull()
    }
}

val dao: DAOFacade = DAOFacadeImpl()

