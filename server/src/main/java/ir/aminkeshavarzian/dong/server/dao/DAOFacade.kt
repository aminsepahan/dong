package ir.aminkeshavarzian.dong.server.dao

import ir.aminkeshavarzian.dong.server.model.DongUser

interface DAOFacade {
    suspend fun allUsers(): List<DongUser>
    suspend fun addUser(name: String, email: String, bankCard: Int, image: String): DongUser?
}
