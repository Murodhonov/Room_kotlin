package uz.umarxon.roomkotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.umarxon.roomkotlin.Entity.Customer
import uz.umarxon.roomkotlin.Entity.Employee
import uz.umarxon.roomkotlin.databinding.ItemRvBinding

class EmployeeAdapter(var context:Context,private val list: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.Vh>() {
    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(customer: Employee, position: Int) {

            itemRv.rvName.text = customer.name

            itemRv.card.startAnimation(AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left))


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}