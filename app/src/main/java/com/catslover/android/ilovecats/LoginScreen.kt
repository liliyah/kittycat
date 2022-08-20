package com.catslover.android.ilovecats

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ResolveInfo
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.catslover.android.ilovecats.databinding.FragmentLoginScreenBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds


class LoginScreen : Fragment() {
    private lateinit var binding: FragmentLoginScreenBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen, container, false)
        MobileAds.initialize(requireActivity()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
        binding.catSounds.setOnClickListener {

            findNavController().navigate(LoginScreenDirections.actionLoginScreenToCatSounds())

        }
        binding.catcaring.setOnClickListener {
            findNavController().navigate(LoginScreenDirections.actionLoginScreenToCaringCatFragment())

        }
        binding.catnames.setOnClickListener {
            findNavController().navigate(LoginScreenDirections.actionLoginScreenToCatsName())

        }
        binding.catpostures.setOnClickListener {
            findNavController().navigate(LoginScreenDirections.actionLoginScreenToCatsPostures())


        }
        binding.imgCatfeed.setOnClickListener {
            findNavController().navigate(LoginScreenDirections.actionLoginScreenToCatsFeed())


        }
        binding.shareapp.setOnClickListener {
            shareApp(requireContext())
        }

        return binding.root
    }

    fun shareApp(context: Context) {
        val appPackageName: String = context.getPackageName()
        val sendIntent = Intent()
        sendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT,
            " https://play.google.com/store/apps/details?id=$appPackageName")
        sendIntent.type = "text/plain"
        context.startActivity(sendIntent)
    }


}