package com.example.android_ejercicios_xml.presentation.cuenta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android_ejercicios_xml.R
import com.example.android_ejercicios_xml.databinding.RegistroNumeroDeCuentaFragmentBinding


class RegistroNumeroDeCuentaFragment : Fragment() {

    val registroNumeroDeCuentaViewModel by viewModels<RegistroNumeroDeCuentaViewModel>()

    private var _binding: RegistroNumeroDeCuentaFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = RegistroNumeroDeCuentaFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.regresarDosMPButton.setOnClickListener {
            findNavController().navigate(R.id.PantallaMenuGeneralFragment)
        }
        binding.registroCuentaBaseDeDatosButton.setOnClickListener {
            val tipoDeCuenta = binding.tipoDeCuentaEditText.text.toString()
            val moneda = binding.monedaEditText.text.toString()
            val saldo = binding.saldoEditText.text.toString()
            registroNumeroDeCuentaViewModel.enviarTipoDeCuenta(tipoDeCuenta)
            registroNumeroDeCuentaViewModel.enviarMoneda(moneda)
            registroNumeroDeCuentaViewModel.enviarSaldo(saldo)
            registroNumeroDeCuentaViewModel.registrarCuenta()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}