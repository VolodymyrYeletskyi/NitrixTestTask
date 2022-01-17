package com.yeletskyiv.nitrixtesttask.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yeletskyiv.nitrixtesttask.model.Drink

class DrinkAdapter : RecyclerView.Adapter<DrinkViewHolder>() {

    private val dataList = mutableListOf<Drink>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        return DrinkViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.update(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun addDrink(drink: Drink) {
        dataList.add(drink)
        notifyItemChanged(dataList.size - 1)
    }

    fun removeDrink(emptyCallback: () -> Unit) {
        if (dataList.isNotEmpty()) {
            notifyItemRemoved(dataList.size - 1)
            dataList.removeAt(dataList.size - 1)
        } else {
            emptyCallback()
        }
    }
}