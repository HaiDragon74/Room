package com.example.bai30rom.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bai30rom.emtity.User

@Dao
interface Dao {
    // Phương thức để thêm một người dùng mới vào cơ sở dữ liệu
    @Insert(onConflict = OnConflictStrategy.IGNORE)  // CHEN  onConflict = OnConflictStrategy.IGNORE kiemtra xung dot
    suspend fun addUser(user:User)

    // Phương thức để đọc tất cả dữ liệu từ bảng user_table và trả về LiveData
    @Query("SELECT * FROM user_table ORDER BY id ASC") //TIM KIEM
    fun readAllData():LiveData<List<User>>

    @Update
    suspend fun updateUser(user: User)  //update


    @Delete
    suspend fun deleteUser(user: User) //delete

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()      //delete all






}