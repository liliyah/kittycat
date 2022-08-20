package com.catslover.android.ilovecats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.catslover.android.Adapters.CatsNamesAdapter
import com.catslover.android.ViewModel.CatsViewModel
import com.catslover.android.dataclasses.CatNames
import com.catslover.android.ilovecats.databinding.FragmentBoygirlcatnamesBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class boygirlcatnames : Fragment() {
    private lateinit var binding: FragmentBoygirlcatnamesBinding
    val args: boygirlcatnamesArgs by navArgs()

    private val viewModel: CatsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_boygirlcatnames, container, false)
        MobileAds.initialize(requireActivity()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
        var listofallnames :List<CatNames> = viewModel.catNamesList
var type = args.catgender
        if (type== 0){
       var femaleCatNames =getgirlslist(listofallnames)
            var adapter = CatsNamesAdapter(femaleCatNames,requireContext())
            binding.recycernames.let {
                it.adapter = adapter
                it.hasFixedSize()
                it.layoutManager =
                    LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            }
        }
        else if (type== 1){


            var maleCatNmaes = getboysList(listofallnames)
            var adapter = CatsNamesAdapter(maleCatNmaes,requireContext())
            binding.recycernames.let {
                it.adapter = adapter
                it.hasFixedSize()
                it.layoutManager =
                    LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            }

        }


        return binding.root
    }
fun getboysList(  listofallnames :List<CatNames>):List<CatNames>{
    val boysList = listofallnames.filter { it.catgender==1 }
return  boysList
}
    fun  getgirlslist( listofallnames :List<CatNames>):List<CatNames>{

        val girlslist = listofallnames.filter { it.catgender==0 }
        return  girlslist

    }



}