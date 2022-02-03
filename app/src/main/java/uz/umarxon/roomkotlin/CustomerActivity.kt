package uz.umarxon.roomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.umarxon.roomkotlin.Adapter.EmployeeAdapter
import uz.umarxon.roomkotlin.Adapter.RvAdapter
import uz.umarxon.roomkotlin.Database.AppDatabase
import uz.umarxon.roomkotlin.Entity.Customer
import uz.umarxon.roomkotlin.databinding.ActivityCustomerBinding

class CustomerActivity : AppCompatActivity() {

    lateinit var binding : ActivityCustomerBinding
    lateinit var db:AppDatabase
    lateinit var customerAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener{
            val customer = Customer()

            customer.name = binding.name.text.toString().trim()

            binding.name.text.clear()

            db.customerDao().addCustomer(customer)
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            onResume()
        }

    }

    override fun onResume() {
        super.onResume()
        db = AppDatabase.getInstance(this)
        val list = ArrayList<Customer>()
        list.addAll(db.customerDao().getAllCustomer())
        customerAdapter = RvAdapter(this,list)
        binding.rv.adapter = customerAdapter
    }
}