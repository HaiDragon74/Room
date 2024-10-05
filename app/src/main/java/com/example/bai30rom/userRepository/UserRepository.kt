package com.example.bai30rom.userRepository
import androidx.lifecycle.LiveData
import com.example.bai30rom.dao.Dao
import com.example.bai30rom.emtity.User

class UserRepository(private var userdao:Dao) {
    val realAllData:LiveData<List<User>> = userdao.readAllData()
    suspend fun addUser(user: User){
        userdao.addUser(user)
    }
    suspend fun updateUser(user: User){
        userdao.updateUser(user)
    }
    suspend fun deleteUser(user: User){
        userdao.deleteUser(user)
    }
    suspend fun deleteAll(){
        userdao.deleteAll()
    }
}