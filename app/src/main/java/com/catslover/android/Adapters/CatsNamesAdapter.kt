package com.catslover.android.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.catslover.android.dataclasses.CatNames
import com.catslover.android.ilovecats.databinding.CatnameItemBinding

class CatsNamesAdapter(private val catNamesList: List<CatNames>, private val context: Context) :
    RecyclerView.Adapter<CatsNamesAdapter.catsViewHolder>() {
    class catsViewHolder(private val binding: CatnameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(catname: CatNames) {

            binding.catnameitem = catname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): catsViewHolder {
val bindingInflater = CatnameItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

return catsViewHolder(bindingInflater)
    }

    override fun onBindViewHolder(holder: catsViewHolder, position: Int) {
var catitem = catNamesList[position]
        holder.bind(catitem)

    }

    override fun getItemCount(): Int = catNamesList.size
}