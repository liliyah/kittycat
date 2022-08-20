package com.catslover.android.ilovecats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.catslover.android.Adapters.CatsFeedAdapter
import com.catslover.android.ViewModel.CatsFeedViewModel
import com.catslover.android.dataclasses.Cat
import com.catslover.android.ilovecats.databinding.FragmentCatsFeedBinding
import com.catslover.android.utils.CatItemListner
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatsFeed : Fragment() {
    private lateinit var binding: FragmentCatsFeedBinding
    private val viewModel: CatsFeedViewModel by activityViewModels()
private var currentCatItem :Cat? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val catfeedlist = viewModel.catsFeedList
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cats_feed, container, false)

        val adapter = CatsFeedAdapter(CatItemListner {
            currentCatItem= it
            //viewModel.setcatItem(it)
viewModel.setNavigateTonextFragmnet(true)

        },catfeedlist,requireContext())
        binding.catsImagesRecycler.let {
            it.adapter = adapter
            it.hasFixedSize()
            it.layoutManager =
                GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
        }
//        viewModel.currentCatItem.observe(viewLifecycleOwner, Observer {
//            currentCatItem = it!!
//
//
//        })

viewModel.navigateTonextFragment.observe(viewLifecycleOwner, Observer {
    if (it==true){

        if(findNavController().currentDestination?.id==R.id.catsFeed)
            findNavController().navigate(
                CatsFeedDirections.actionCatsFeedToCatsFeedDetailsFragmnet(currentCatItem!!)
            )
        viewModel.setNavigateTonextFragmnet(false)
    }

})
        return binding.root
    }


}