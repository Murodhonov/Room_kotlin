package uz.umarxon.roomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import uz.umarxon.roomkotlin.Adapter.OrderAdapter
import uz.umarxon.roomkotlin.Adapter.RvAdapter
import uz.umarxon.roomkotlin.Database.AppDatabase
import uz.umarxon.roomkotlin.Entity.Customer
import uz.umarxon.roomkotlin.Entity.Employee
import uz.umarxon.roomkotlin.Entity.Orders
import uz.umarxon.roomkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var db : AppDatabase
    lateinit var orderAdapter: OrderAdapter
    var listCustomer:ArrayList<Customer> = ArrayList()
    var listEmployee:ArrayList<Employee> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener{
            val orders = Orders()

            orders.customerId = listCustomer[binding.spinnerCustomer.selectedItemPosition].id
            orders.employeeId = listEmployee[binding.spinnerEmployee.selectedItemPosition].id

            db.ordersDao().addOrders(orders)

            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()
            onResume()
        }

    }

    override fun onResume() {
        super.onResume()
        db = AppDatabase.getInstance(this)

        val list = ArrayList<Orders>()

        list.addAll(db.ordersDao().getAllOrders())

        orderAdapter = OrderAdapter(db,this,list)

        binding.rv.adapter= orderAdapter

        listCustomer.addAll(db.customerDao().getAllCustomer())
        listEmployee.addAll(db.employeeDao().getAllEmployee())

        val customerListName = ArrayList<String>()
        val employeeListName = ArrayList<String>()

        for (employee in listEmployee){
            employeeListName.add(employee.name!!)
        }

        for (customer in listCustomer){
            customerListName.add(customer.name!!)
        }

        val customerSpinnerAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,customerListName)
        val employeeSpinnerAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,employeeListName)

        binding.spinnerCustomer.adapter = customerSpinnerAdapter
        binding.spinnerEmployee.adapter = employeeSpinnerAdapter

    }
}