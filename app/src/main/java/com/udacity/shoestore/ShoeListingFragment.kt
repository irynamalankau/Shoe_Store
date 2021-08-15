package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.databinding.ListItemBinding
import com.udacity.shoestore.models.StoreViewModel
import com.udacity.shoestore.models.Shoe


class ShoeListingFragment : Fragment() {

    private val viewModel: StoreViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeListingBinding

    private lateinit var listItemBinding: ListItemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_listing, container, false)

        //set up navigation to the next fragment when the Next btn is clicked
        binding.addBtnListing.setOnClickListener{
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToDetailsFragment())

        }

        viewModel.shoesList.observe(viewLifecycleOwner, Observer {
            for (shoe in it){
                addItemToLayout(shoe)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    //adding new shoe item view to layout
    fun addItemToLayout(item: Shoe){
        listItemBinding = ListItemBinding.inflate(LayoutInflater.from(requireContext()))
        listItemBinding.shoe = item

        binding.list.addView(listItemBinding.listItem)
    }

    //inflate options menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}