package com.example.navigationpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationpractice.databinding.FragmentViewTransactionBinding


class ViewTransactionFragment : Fragment(R.layout.fragment_view_transaction){

    private var _binding : FragmentViewTransactionBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentViewTransactionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.doneBtn.setOnClickListener {
            val action = ViewTransactionFragmentDirections.actionViewTransactionFragmentToSendCashFragment(200,"receive")

            findNavController().navigate(action)
        }

    }

}