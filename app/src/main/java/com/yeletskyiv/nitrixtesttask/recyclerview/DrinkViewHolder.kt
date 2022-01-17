package com.yeletskyiv.nitrixtesttask.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yeletskyiv.nitrixtesttask.R
import com.yeletskyiv.nitrixtesttask.model.Drink
import kotlinx.android.synthetic.main.recycler_item_layout.view.*

class DrinkViewHolder(
    layoutInflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.recycler_item_layout, parent, false)) {

    fun update(drink: Drink) {
        with(itemView) {
            drink_image.load(drink.imageUrl) {
                crossfade(true)
            }
            drink_title.text = drink.name
            drink_receipt.text = drink.receipt
        }
    }
}