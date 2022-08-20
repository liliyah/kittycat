package com.catslover.android.repositories

import com.catslover.android.dataclasses.CatNames
import com.catslover.android.dataclasses.CatSounds
import com.catslover.android.dataclasses.Cat

interface CatsSoundsInterface {
    fun getCatSoundsList(): List<CatSounds>
    fun getCatsNamesList():List<CatNames>
}