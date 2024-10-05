package com.example.bai30rom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bai30rom.dao.Dao
import com.example.bai30rom.emtity.User

@Database(entities = [User::class], version = 1, exportSchema = false)

abstract class UserDatabase: RoomDatabase() {
    // Phương thức trừu tượng để trả về đối tượng DAO liên quan đến người dùng
    abstract fun UserDao():Dao
    // Đối tượng đồng minh để quản lý việc tạo và cung cấp một instance của UserDatabase
    companion object{
        @Volatile
        // Biến INSTANCE được đánh dấu với @Volatile để đảm bảo việc đọc và ghi an toàn trong môi trường đa luồng
        private var INSTANCE: UserDatabase? =null
        // Hàm này nhận vào một Context và trả về một instance của UserDatabase
        fun getDatabase(context: Context):UserDatabase{
            val tempInstance = INSTANCE
            // Kiểm tra xem đã có instance của UserDatabase hay chưa
            if (tempInstance!=null){
                // Nếu đã tồn tại, trả về instance đó
                return tempInstance
            }
            // Sử dụng synchronized để đảm bảo chỉ có một luồng thực hiện tạo instance vào một thời điểm
            synchronized(this){
                // Tạo instance của UserDatabase thông qua Room's databaseBuilder
                val instance=Room.databaseBuilder(
                    context.applicationContext, // Context ứng dụng
                    UserDatabase::class.java, // Lớp database
                    "user_table" // Tên của cơ sở dữ liệu
                ).build()
                // Gán instance mới tạo vào biến INSTANCE để duy trì mô hình Singleton
                INSTANCE=instance
                // Trả về instance mới tạo
                return instance
            }
        }
    }

}