package com.catslover.android.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catslover.android.dataclasses.CatNames
import com.catslover.android.dataclasses.CatSounds
import com.catslover.android.dataclasses.Cat
import com.catslover.android.repositories.CatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class CatsViewModel @Inject constructor(private  val catsRepository: CatsRepository):ViewModel() {
lateinit var catNamesList: List<CatNames>
    lateinit var catSoundsList: List<CatSounds>
    private val mutableInterstitialItem = MutableLiveData<Int>()
 val currentInterstitialItem: LiveData<Int> get() = mutableInterstitialItem
    init {
loadCatsNames()
        loadcatssounds()
    }


    private fun loadcatssounds() {
        catNamesList = catsRepository.getCatsNamesList()
    }

    private fun loadCatsNames() {
        catSoundsList = catsRepository.getCatSoundsList()
    }
    fun setInterstitialAd(AdItem:Int){
        mutableInterstitialItem.value= AdItem
    }


}