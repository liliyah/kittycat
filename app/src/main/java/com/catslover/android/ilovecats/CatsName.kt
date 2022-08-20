package com.catslover.android.ilovecats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.catslover.android.ilovecats.databinding.FragmentCatSoundsBinding
import com.catslover.android.ilovecats.databinding.FragmentCatsNameBinding

class catsName : Fragment() {
    private lateinit var binding: FragmentCatsNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cats_name, container, false)
binding.girlbutton.setOnClickListener {
findNavController().navigate(catsNameDirections.actionCatsNameToBoygirlcatnames(0))

}

binding.boybotton.setOnClickListener {
    findNavController().navigate(catsNameDirections.actionCatsNameToBoygirlcatnames(1))


}
        return binding.root
    }


}