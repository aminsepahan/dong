package ir.aminkeshavarzian.dong.server.dao

import ir.aminkeshavarzian.dong.server.model.DongUser

interface DAOFacade {
    suspend fun allUsers(): List<DongUser>
    suspend fun addUser(name: String, email: String, bankCard: String, phoneNumber: String): DongUser?
    suspend fun editUser(id: Int, name: String, email: String, bankCard: String, phoneNumber: String): Boolean
    suspend fun deleteUser(id: Int): Boolean
    suspend fun getUser(id: Int): DongUser?
}
