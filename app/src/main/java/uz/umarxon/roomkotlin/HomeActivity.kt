package uz.umarxon.roomkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.umarxon.roomkotlin.Entity.Orders
import uz.umarxon.roomkotlin.databinding.ActivityHomeBinding
import uz.umarxon.roomkotlin.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEmployee.setOnClickListener{
            startActivity(Intent(this,EmployeeActivity::class.java))
        }

        binding.btnCustomer.setOnClickListener{
            startActivity(Intent(this,CustomerActivity::class.java))
        }

        binding.btnOrder.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}