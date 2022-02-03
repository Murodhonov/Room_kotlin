package uz.umarxon.roomkotlin.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.umarxon.roomkotlin.Dao.CustomerDao
import uz.umarxon.roomkotlin.Dao.EmployeeDao
import uz.umarxon.roomkotlin.Dao.OrdersDao
import uz.umarxon.roomkotlin.Entity.Customer
import uz.umarxon.roomkotlin.Entity.Employee
import uz.umarxon.roomkotlin.Entity.Orders

@Database(entities = [Customer::class,Employee::class,Orders::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun customerDao():CustomerDao
    abstract fun employeeDao():EmployeeDao
    abstract fun ordersDao(): OrdersDao

    companion object{
        private var instanse:AppDatabase?= null

        @Synchronized
        fun getInstance(context: Context):AppDatabase{

            when(instanse){
                null->{
                    instanse = Room.databaseBuilder(context,AppDatabase::class.java,"db_order")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }

            return instanse!!
        }

    }
}