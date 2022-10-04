package com.example.android_ejercicios_xml.presentation.movimiento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android_ejercicios_xml.R
import com.example.android_ejercicios_xml.databinding.MovimientoFragmentBinding


class MovimientoFragment : Fragment() {

    val movimientoViewModel by viewModels<MovimientoViewModel>()
    private var _binding: MovimientoFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = MovimientoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.regresarTresMPButton.setOnClickListener {
            findNavController().navigate(R.id.PantallaMenuGeneralFragment)
        }
        binding.registrarMovimientoButton.setOnClickListener {
            val tipoDeOperacion = binding.tipoDeOperacionRadioGroup.checkedRadioButtonId.toString()
            val importe = binding.importeEditText.text.toString()
            val descripcion = binding.descripcionEditText.text.toString()


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}