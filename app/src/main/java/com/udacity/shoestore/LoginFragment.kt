package com.udacity.shoestore
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    //Inflating and Returning the View with DataBindingUtil
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //set up data binding
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_login, container, false)
        //set up navigation to the next fragment when the Login btn is clicked
        binding.login.setOnClickListener{v: View ->
            v.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        }

        return binding.root
    }

}