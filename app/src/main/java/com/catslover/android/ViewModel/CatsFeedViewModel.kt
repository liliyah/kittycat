package com.catslover.android.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.catslover.android.dataclasses.Cat
import com.catslover.android.repositories.CatsFeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatsFeedViewModel @Inject constructor( private val Repository: CatsFeedRepository):ViewModel(){
    lateinit var catsFeedList:List<Cat>

//    private val mutablecurrentcatItem = MutableLiveData<Cat>()
//    val currentCatItem: LiveData<Cat?> get() = mutablecurrentcatItem
    private val _navigateTonextFragment= MutableLiveData<Boolean>()
    val navigateTonextFragment:LiveData<Boolean> get() = _navigateTonextFragment
init {

    loadCatsFeed()

}
   fun setNavigateTonextFragmnet(navigate:Boolean){

       _navigateTonextFragment.value = navigate

   }

//    fun setcatItem (catitem:Cat){
//
//        mutablecurrentcatItem.value = catitem
//    }


    private fun loadCatsFeed(){

        catsFeedList = Repository.getCatsFeedList()
    }
}