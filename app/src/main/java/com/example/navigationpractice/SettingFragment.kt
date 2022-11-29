package com.example.navigationpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationpractice.databinding.FragmentSettingBinding


class SettingFragment : Fragment(){

    private lateinit var _binding: FragmentSettingBinding

    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSettingBinding.inflate(inflater,container,false)
        return  binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val amount = binding.etvAmount.text.toString()
            SampleData.defaultAmount.value = amount.toLong()
        }

        binding.btnAboutApp.setOnClickListener {
            val action = HomeFragmentDirections.actionGlobalAboutAppFragment()
            findNavController().navigate(action)
        }
    }
}