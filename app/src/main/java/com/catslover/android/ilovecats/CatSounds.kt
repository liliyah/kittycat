package com.catslover.android.ilovecats

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.catslover.android.Adapters.CatsSoundsAdapter
import com.catslover.android.ViewModel.CatsViewModel
import com.catslover.android.ilovecats.databinding.FragmentCatSoundsBinding
import com.catslover.android.ilovecats.databinding.FragmentLoginScreenBinding
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatSounds : Fragment() {
    private val viewModel: CatsViewModel by activityViewModels()
    private lateinit var binding: FragmentCatSoundsBinding
    private lateinit var adapter: CatsSoundsAdapter
    private var mInterstitialAd: InterstitialAd? = null
    val AD_UNIT_ID = "ca-app-pub-2020667111518171/2000503188"
    private var mAdIsLoading: Boolean = false
    private val TAG = "CatSounds"
    companion object{
        var handler: Handler = Handler(Looper.getMainLooper())
        var runnable: Runnable = Runnable { }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cat_sounds, container, false)

        val catsoundlist = viewModel.catSoundsList
        adapter = CatsSoundsAdapter(catsoundlist, requireContext())
        binding.soundrecycler.let {
            it.adapter = adapter
            it.hasFixedSize()
            it.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MobileAds.initialize(requireActivity()) {}
        loadAd()
        runnable = object : Runnable {
            override fun run() {

                showInterstitialAds()

                handler.postDelayed(this, 120000)
            }
        }
        handler.postDelayed(runnable, 0)



    }
    override fun onStop() {
        adapter.clearMediaPlayer()
     handler.removeCallbacks(CatsSoundsAdapter.runnable)
        super.onStop()
    }

    fun showad() {
        if (mInterstitialAd != null) {
            Log.d("ad", "the ad is notnull ")

            mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d("ad", "the ad is dissmissed ")
                    super.onAdDismissedFullScreenContent()
                    mInterstitialAd = null
                    loadAd()
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    mInterstitialAd = null
                    Log.d("ad", "the ad has failed ")
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d("ad", "ad showed full screen ")

                }

            }

            mInterstitialAd?.show(this.requireActivity())
        }

    }

    fun loadAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            requireContext(), AD_UNIT_ID, adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d("aderror", adError.message)
                    mInterstitialAd = null
                    mAdIsLoading = false
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d("adlodedemessage", "Ad was completly loaded.")
                    mInterstitialAd = interstitialAd
                    mAdIsLoading = false

                }
            }
        )

    }

    fun showInterstitialAds() {
        if (mInterstitialAd != null) {
            showad()
            Log.d("ad", "ad on back exists ")

        } else if (mInterstitialAd == null) {
            mAdIsLoading = true
            loadAd()
            Log.d("ad", "ad are null ")

        }
    }

    override fun onDetach() {
        adapter.clearMediaPlayer()
        handler.removeCallbacks(CatsSoundsAdapter.runnable)
        super.onDetach()
    }

    override fun onPause() {
        adapter.clearMediaPlayer()
        handler.removeCallbacks(CatsSoundsAdapter.runnable)
        super.onPause()
    }

}