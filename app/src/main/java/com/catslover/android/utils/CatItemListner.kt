package com.catslover.android.utils

import com.catslover.android.dataclasses.Cat

class CatItemListner(val clicklistner :(catItem:Cat)-> Unit) {
    fun onClick(itemcat:Cat)=clicklistner(itemcat)

}