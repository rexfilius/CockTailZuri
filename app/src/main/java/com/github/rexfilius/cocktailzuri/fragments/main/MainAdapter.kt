package com.github.rexfilius.cocktailzuri.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.github.rexfilius.cocktailzuri.api.Drink
import com.github.rexfilius.cocktailzuri.databinding.ItemRvBinding

class MainAdapter(
    private val drinks: List<Drink>,
    private val listener: (Drink) -> Unit
) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(drinks[position])
    }

    override fun getItemCount(): Int {
        return drinks.size
    }


    inner class MainViewHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(drink: Drink) {
            binding.title.text = drink.drinkName
            binding.thumbIv.load(drink.drinkThumb)
            binding.root.setOnClickListener {
                listener.invoke(drink)
            }
        }
    }
}