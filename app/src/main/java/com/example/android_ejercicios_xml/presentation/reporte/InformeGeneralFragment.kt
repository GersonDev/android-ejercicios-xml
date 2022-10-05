package com.example.android_ejercicios_xml.presentation.reporte

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android_ejercicios_xml.R
import com.example.android_ejercicios_xml.databinding.InformeGeneralFragmentBinding


class InformeGeneralFragment : Fragment() {

    val informeGeneralViewModel by viewModels<InformeGeneralViewModel>()

    private var _binding: InformeGeneralFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = InformeGeneralFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        informeGeneralViewModel.informeGeneral.observe(viewLifecycleOwner, Observer {
            binding.infromeGeneralTextView.text = it
        })

        binding.regresarCuatroMPButton.setOnClickListener {
            findNavController().navigate(R.id.PantallaMenuGeneralFragment)
        }
        binding.BuscarButton.setOnClickListener {
            val dni = binding.dniInformeEditText.text.toString()

            informeGeneralViewModel.registrarInformeGeneral()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}