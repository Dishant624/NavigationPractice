package com.example.navigationpractice

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.navigationpractice.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home){

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost : MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId){
                    androidx.appcompat.R.id.home -> {
                        findNavController().navigateUp()
                        return true
                    }
                    R.id.item_about_app ->{
                        val action = HomeFragmentDirections.actionGlobalAboutAppFragment()
                        findNavController().navigate(action)
                        true
                    }else -> menuItem.onNavDestinationSelected(findNavController())
                }
            }

        },viewLifecycleOwner, Lifecycle.State.RESUMED)

        binding.btnViewBalance.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
            findNavController().navigate(action)
        }

        binding.btnSendMoney.setOnClickListener {
                val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
                findNavController().navigate(action)

            //    findNavController().navigate(R.id.action_homeFragment_to_chooseReceiverFragment)
        }

        binding.btnViewTransaction.setOnClickListener {

                val navOption = NavOptions.Builder()
                    .setEnterAnim(R.anim.slide_in_right)
                    .setExitAnim(R.anim.slide_out_left)
                    .setPopEnterAnim(R.anim.slide_in_left)
                    .setPopExitAnim(R.anim.slide_out_right)
                    .build()

                findNavController().navigate(R.id.viewTransactionFragment,null,navOption)
        }
    }
}
