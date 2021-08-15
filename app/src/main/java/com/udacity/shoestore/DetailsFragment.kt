package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.StoreViewModel
import com.udacity.shoestore.models.Shoe


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    private val viewModel: StoreViewModel by activityViewModels()

    private val shoe = Shoe("", "", "", "")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //set up data binding
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false)

        binding.shoe = shoe

        binding.saveBtnDetails.setOnClickListener{
            viewModel.shoesList.value?.add(shoe)
            navigate()

        }

        binding.cancelBtnDetails.setOnClickListener{
            navigate()
        }

        return binding.root
    }

    private fun navigate(){
        //set up navigation to the listing fragment
            findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListingFragment())
        }

}