package uz.umarxon.roomkotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.umarxon.roomkotlin.Database.AppDatabase
import uz.umarxon.roomkotlin.Entity.Employee
import uz.umarxon.roomkotlin.Entity.Orders
import uz.umarxon.roomkotlin.databinding.ItemRvBinding
import uz.umarxon.roomkotlin.databinding.OrderItemBinding

class OrderAdapter(var appDatabase: AppDatabase,var context: Context, private val list: List<Orders>) :
    RecyclerView.Adapter<OrderAdapter.Vh>() {
    inner class Vh(var itemRv: OrderItemBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(customer: Orders, position: Int) {

            itemRv.rvDate.text = customer.date
            itemRv.rvCustomer.text = appDatabase.customerDao().getCustomerById(customer.customerId!!).name
            itemRv.rvEmployee.text = appDatabase.employeeDao().getEmployeeById(customer.employeeId!!).name

            itemRv.card.startAnimation(AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(OrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}