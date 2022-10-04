package com.example.android_ejercicios_xml.presentation.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android_ejercicios_xml.databinding.PantallaMenuGeneralFragmentBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PantallaMenuGeneralFragment : Fragment() {

    private var _binding: PantallaMenuGeneralFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PantallaMenuGeneralFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registroClienteButton.setOnClickListener {
            findNavController().navigate(
                PantallaMenuGeneralFragmentDirections.actionPantallaMenuGeneralFragmentToRegistroClienteFragment()
            )
        }
        binding.registroNumeroDeCuentaButton.setOnClickListener {
            findNavController().navigate(
                PantallaMenuGeneralFragmentDirections.actionPantallaMenuGeneralFragmentToRegistroNumeroDeCuentaFragment()
            )
        }
        binding.movimientosButton.setOnClickListener {
            findNavController().navigate(
                PantallaMenuGeneralFragmentDirections.actionPantallaMenuGeneralFragmentToMovimientoFragment()
            )
        }
        binding.informeGeneralButton.setOnClickListener {
            findNavController().navigate(PantallaMenuGeneralFragmentDirections.actionPantallaMenuGeneralFragmentToInformeGeneralFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}