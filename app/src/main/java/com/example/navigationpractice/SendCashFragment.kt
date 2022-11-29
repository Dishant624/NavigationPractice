package com.example.navigationpractice

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationpractice.databinding.FragmentSendCashBinding


class SendCashFragment : Fragment(R.layout.fragment_send_cash){
    private var _binding : FragmentSendCashBinding? = null

    private val binding get() = _binding!!

    private val args : SendCashFragmentArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSendCashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost : MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.empty_menu,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return true
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        val name = args.name
        val amount = args.amount

        binding.etAmount.setText( amount.toString())
        binding.tvReceiver.text = "Receiver Name $name"

        binding.etAmount.setText(SampleData.defaultAmount.value.toString())
        SampleData.defaultAmount.observe(viewLifecycleOwner){
            binding.etAmount.setText(it.toString())
        }

        binding.btnSend.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment()
            findNavController().navigate(action)
        }

        binding.btnDone.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, inclusive = false)
        }

    }

}