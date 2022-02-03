package uz.umarxon.roomkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.umarxon.roomkotlin.Adapter.EmployeeAdapter
import uz.umarxon.roomkotlin.Database.AppDatabase
import uz.umarxon.roomkotlin.Entity.Employee
import uz.umarxon.roomkotlin.databinding.ActivityEmployeeBinding

class EmployeeActivity : AppCompatActivity() {

    lateinit var binding: ActivityEmployeeBinding
    lateinit var employeeAdapter: EmployeeAdapter
    lateinit var db:AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        binding.add.setOnClickListener{
            val employee = Employee()

            employee.name = binding.name.text.toString().trim()

            binding.name.text.clear()

            db.employeeDao().addEmployee(employee)
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            onResume()
        }

    }

    override fun onResume() {
        super.onResume()

        db = AppDatabase.getInstance(this)
        val list = ArrayList<Employee>()
        list.addAll(db.employeeDao().getAllEmployee() as ArrayList<Employee>)
        employeeAdapter = EmployeeAdapter(this,list)
        binding.rv.adapter = employeeAdapter
    }
}