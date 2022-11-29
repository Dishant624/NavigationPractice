package com.example.navigationpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.navigationpractice.databinding.FragmentNotificationBinding



class NotificationFragment : Fragment(R.layout.fragment_notification){

    private var _binding : FragmentNotificationBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentNotificationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lvNotifications.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,getNotification())
    }

    private fun getNotification(): List<String> {

        val notification = mutableListOf<String>()

        for (i in 1..20){
            notification.add("Notification $i")
        }

        return notification

    }

}