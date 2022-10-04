package com.example.android_ejercicios_xml.presentation.cliente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android_ejercicios_xml.R
import com.example.android_ejercicios_xml.databinding.RegistroClienteFragmentBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegistroClienteFragment : Fragment() {

    val registroClienteViewModel by viewModels<RegistroClienteViewModel>()

    private var _binding: RegistroClienteFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = RegistroClienteFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.regresarUnoMPButton.setOnClickListener {
            findNavController().navigate(R.id.PantallaMenuGeneralFragment)
        }
        binding.registrarClienteBaseDeDatoButton.setOnClickListener {
            val dni = binding.dniEditText.text.toString()
            val nombre = binding.nombreEditText.text.toString()
            val direccion = binding.direccionEditText.text.toString()
            val distrito = binding.distritoEditText.text.toString()
            registroClienteViewModel.enviarDni(dni)
            registroClienteViewModel.enviarNombre(nombre)
            registroClienteViewModel.enviarDireccion(direccion)
            registroClienteViewModel.enviarDistrito(distrito)

            registroClienteViewModel.registrarCliente()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}