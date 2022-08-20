package com.catslover.android.repositories

import android.content.Context
import com.catslover.android.dataclasses.Cat
import com.catslover.android.ilovecats.R

class CatsFeedRepository( val  context: Context) {
     fun getCatsFeedList(): List<Cat> = listOf(
    Cat(context.getString(R.string.maw_cat),context.getString(R.string.maw_cat_feed),R.drawable.arabiccat),
    Cat(context.getString(R.string.sphinx_cat),context.getString(R.string.sphinx_cat_feed),R.drawable.shnynxcat),
    Cat(context.getString(R.string.shirazy_cat),context.getString(R.string.shirazy_cat_feed),R.drawable.sherazycat),
    Cat(context.getString(R.string.siami_cat),context.getString(R.string.siami_cat_feed),R.drawable.syamicat),
    Cat(context.getString(R.string.pregnant_cat),context.getString(R.string.pregnant_cat_feed),R.drawable.preganatcat),
    Cat(context.getString(R.string.baby_cat),context.getString(R.string.baby_cat_feed),R.drawable.babycat),
    Cat(context.getString(R.string.hymalaya_cat),context.getString(R.string.hymalaya_cat_feed),R.drawable.hymalayacat),
    Cat(context.getString(R.string.peermancat),context.getString(R.string.peermancat_feed),R.drawable.peermancat),
    Cat(context.getString(R.string.devonrexcat),context.getString(R.string.devonrexfeed),R.drawable.devonrexcat),
    Cat(context.getString(R.string.scotchcat),context.getString(R.string.scotchcat_feed),R.drawable.scottichflod),
    Cat(context.getString(R.string.maincooncat),context.getString(R.string.maincooncat_feed),R.drawable.maincoon),
    Cat(context.getString(R.string.britichcat),context.getString(R.string.britichcat_feed),R.drawable.britichcat),
    Cat(context.getString(R.string.raghdoolcat),context.getString(R.string.raghdoolcat_feed),R.drawable.ragdoolcat),
    Cat(context.getString(R.string.habashicat),context.getString(R.string.habashicat_feed),R.drawable.habashicat),
    Cat(context.getString(R.string.cateat),context.getString(R.string.cateat_feed),R.drawable.cateat),
         Cat(context.getString(R.string.bobtail),context.getString(R.string.bobtail_feed),R.drawable.bobtailcat),

    )

}