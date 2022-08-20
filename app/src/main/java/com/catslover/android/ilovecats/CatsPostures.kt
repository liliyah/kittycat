package com.catslover.android.ilovecats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.catslover.android.ilovecats.databinding.FragmentCatsPosturesBinding
import com.catslover.android.ilovecats.databinding.FragmentLoginScreenBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class CatsPostures : Fragment() {

    private lateinit var binding: FragmentCatsPosturesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cats_postures, container, false)

        MobileAds.initialize(requireActivity()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        return binding.root
    }


}