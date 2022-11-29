package com.example.navigationpractice

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.navigationpractice.databinding.FragmentChooseReceiverBinding

class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver){

    private var _binding : FragmentChooseReceiverBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentChooseReceiverBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val menuHost : MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.empty_menu,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId){
                    androidx.appcompat.R.id.home -> {
                        findNavController().navigateUp()
                        return true
                    }
                    R.id.item_about_app ->{
                        val action = HomeGraphDirections.actionGlobalAboutAppFragment()
                        findNavController().navigate(action)
                        true
                    }else -> menuItem.onNavDestinationSelected(findNavController())
                }
            }

        },viewLifecycleOwner, Lifecycle.State.RESUMED)

        binding.btnNext.setOnClickListener {
            val name = binding.nameEtv.text.toString()

            val action = ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(name)
            findNavController().navigate(action)
        }

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}
