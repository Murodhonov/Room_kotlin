package uz.umarxon.roomkotlin.Dao

import androidx.room.*
import uz.umarxon.roomkotlin.Entity.Customer

@Dao
interface CustomerDao {
    @Query("select * from customer")
    fun getAllCustomer():List<Customer>

    @Insert
    fun addCustomer(customer: Customer)

    @Delete
    fun deleteCustomer(customer: Customer)

    @Update
    fun updateCustomer(customer: Customer)

    @Query("select * from customer where id=:id")
    fun getCustomerById(id:Int):Customer
}