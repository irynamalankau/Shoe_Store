package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.databinding.FragmentInstructionsBinding


class DetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //set up data binding
        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false)
        //set up navigation to the next fragment when the Next btn is clicked
        binding.saveBtnDetails.setOnClickListener{v: View ->
            v.findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListingFragment())
        }

        binding.cancelBtnDetails.setOnClickListener{v: View ->
            v.findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListingFragment())
        }

        return binding.root
    }

}