package com.catslover.android.ilovecats

import android.os.Bundle
import android.text.Spanned
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.catslover.android.ilovecats.databinding.FragmentCatsFeedBinding
import com.catslover.android.ilovecats.databinding.FragmentCatsFeedDetailsFragmnetBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint

class CatsFeedDetailsFragmnet : Fragment() {
    val args: CatsFeedDetailsFragmnetArgs by navArgs()
    private lateinit var binding: FragmentCatsFeedDetailsFragmnetBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
var catfeedItem = args.catItem
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cats_feed_details_fragmnet, container, false)
        MobileAds.initialize(requireActivity()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
        binding.catnametext.text= catfeedItem.catType.toString()
        binding.catnametext.gravity=Gravity.CENTER
binding.imgcatphoto.setImageResource(catfeedItem.catImage)
        binding.feeddetails.text= catfeedItem.catfeed.toString()


        return binding.root
    }


}