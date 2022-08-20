package com.catslover.android.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.catslover.android.dataclasses.Cat
import com.catslover.android.utils.CatItemListner
import com.catslover.android.ilovecats.databinding.CatfeedRecycleritemBinding

class CatsFeedAdapter(val clicklistner: CatItemListner, private val catFeedList: List<Cat>, private val context: Context) :
    RecyclerView.Adapter<CatsFeedAdapter.catsfeedViewHolder>() {
    class catsfeedViewHolder(private val binding: CatfeedRecycleritemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(cat: Cat, clicklistner: CatItemListner) {
            binding.cat = cat
            binding.clicklistner = clicklistner
        }
    }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): catsfeedViewHolder {
        val bindingInflater = CatfeedRecycleritemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return catsfeedViewHolder(bindingInflater)
    }
  override fun getItemCount(): Int = catFeedList.size


    override fun onBindViewHolder(holder: CatsFeedAdapter.catsfeedViewHolder, position: Int) {
var catfeeitem = catFeedList[position]
        holder.bind(catfeeitem!!,clicklistner)
    }
}
