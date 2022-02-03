package uz.umarxon.roomkotlin.Dao

import androidx.room.*
import uz.umarxon.roomkotlin.Entity.Customer
import uz.umarxon.roomkotlin.Entity.Orders

@Dao
interface OrdersDao {
    @Query("select * from orders")
    fun getAllOrders():List<Orders>

    @Insert
    fun addOrders(orders: Orders)

    @Delete
    fun deleteOrders(orders: Orders)

    @Update
    fun updateOrders(orders: Orders)

    @Query("select * from orders where id=:id")
    fun getOrdersById(id:Int): Orders
}