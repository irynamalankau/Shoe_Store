package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //set up data binding
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instructions, container, false)
        //set up navigation to the next fragment when the Next btn is clicked
        binding.nextBtnInstructions.setOnClickListener{v: View ->
            v.findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListingFragment())

        }

        return binding.root
    }
}