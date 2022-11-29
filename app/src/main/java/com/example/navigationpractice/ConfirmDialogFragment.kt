package com.example.navigationpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.navigationpractice.databinding.FragmentConfirmDialogBinding
import com.example.navigationpractice.databinding.FragmentSendCashBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ConfirmDialogFragment : BottomSheetDialogFragment(){
    private var _binding : FragmentConfirmDialogBinding? = null

    private val binding get() = _binding!!

    private val args : SendCashFragmentArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentConfirmDialogBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}