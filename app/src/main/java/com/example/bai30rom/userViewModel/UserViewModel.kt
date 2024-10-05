package com.example.bai30rom.userViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bai30rom.database.UserDatabase
import com.example.bai30rom.emtity.User
import com.example.bai30rom.userRepository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application:Application):AndroidViewModel(application) {
    // LiveData để quan sát sự thay đổi trong danh sách người dùng
        var realAllData:LiveData<List<User>>
        private val repository:UserRepository
        init {
            // Khởi tạo DAO từ cơ sở dữ liệu
            val dao=UserDatabase.getDatabase(application).UserDao()
            // Khởi tạo repository với DAO
            repository=UserRepository(dao)
            // Gán LiveData từ repository cho realAllData
            realAllData=repository.realAllData

        }
    // Hàm thêm một người dùng vào hệ thống
     fun addUser(user: User){

        // Bắt đầu một coroutine trong phạm vi của ViewModel
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }
    fun updaterUser(user: User){
        // Bắt đầu một coroutine trong phạm vi của ViewModel
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }
    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteUser(user)
        }
    }
    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAll()
        }
    }
}