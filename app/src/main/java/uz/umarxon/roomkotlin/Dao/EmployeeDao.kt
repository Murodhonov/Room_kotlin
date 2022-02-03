package uz.umarxon.roomkotlin.Dao

import androidx.room.*
import uz.umarxon.roomkotlin.Entity.Employee

@Dao
interface EmployeeDao {

    @Query("select * from employee")
    fun getAllEmployee():List<Employee>

    @Insert
    fun addEmployee(employeeDao: Employee)

    @Delete
    fun deleteEmployee(employeeDao: Employee)

    @Update
    fun updateEmployee(employeeDao: Employee)

    @Query("select * from employee where id=:id")
    fun getEmployeeById(id:Int): Employee

}