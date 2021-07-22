package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentShoeListingBinding

/**
 * A fragment representing a list of Items.
 */
class ShoeListingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //set up data binding
        val binding: FragmentShoeListingBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_listing, container, false)
        //set up navigation to the next fragment when the Next btn is clicked
        binding.addBtnListing.setOnClickListener{v: View ->
            v.findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToDetailsFragment())

        }

        return binding.root
    }
}