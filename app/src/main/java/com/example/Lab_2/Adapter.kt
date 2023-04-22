package com.example.Lab_2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.Lab_2.databinding.ItemActivityBinding

class Adapter(
    val context: Context,
    val onClick: (model: Cat, position: Int) -> Unit,
) : RecyclerView.Adapter<Adapter.GamesHolder>() {
    private val list = ArrayList<Cat>()

    inner class GamesHolder(val binding: ItemActivityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(cat: Cat, position: Int) {
            binding.tv1.text = cat.Name
            binding.tv2.text = cat.Poroda
            Glide.with(context)
                .load(cat.ResId)
                .into(binding.imageView)
            binding.info.setOnClickListener {
                onClick(cat, position)
                val navController = binding.root.findNavController()
                val bundle = Bundle()
                bundle.putString("myTextView", cat.Opus)
                bundle.putString("myTextView2", cat.Name)
                navController.navigate(R.id.firstToSecond, bundle)
            }


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesHolder {
        val view = ItemActivityBinding.inflate(LayoutInflater.from(context), parent, false)
        return GamesHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GamesHolder, position: Int) {
        val cat = list[position]
        holder.bindView(cat, position)


    }

    fun setNewData(newList: List<Cat>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()

    }

}