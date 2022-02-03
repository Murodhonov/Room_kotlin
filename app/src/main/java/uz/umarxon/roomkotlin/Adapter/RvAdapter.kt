package uz.umarxon.roomkotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.umarxon.roomkotlin.Entity.Customer
import uz.umarxon.roomkotlin.databinding.ItemRvBinding

class RvAdapter(var context:Context,private val list: List<Customer>) :
    RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(customer: Customer, position: Int) {

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