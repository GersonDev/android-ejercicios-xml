package com.example.android_ejercicios_xml

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android_ejercicios_xml.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    //var selectedDate: String="" o
    lateinit var selectedDate: String
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fechaEditText.setOnClickListener {
            showDatePickerDialog()
        }
        binding.calcularButton.setOnClickListener {
            val plazoTotal = binding.plazoTotalEditText.text.toString()
            val prestamo = binding.prestamoEditText.text.toString()
            if (plazoTotal == "" ||prestamo == ""||selectedDate == "") {
                binding.plazoTotalEditText.error = "Hubo un error este campo es obligatorio"
                binding.prestamoEditText.error = "Hubo un error este campo es obligatorio"
                binding.fechaEditText.error = "Hubo un error este campo es obligatorio"
                return@setOnClickListener
            }
            findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                    fecha = selectedDate,
                    plazoTotal = plazoTotal.toInt(),
                    prestamo = prestamo.toFloat()
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showDatePickerDialog() {
        val newFragment =
            DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->
                selectedDate = "$day/${month + 1}/$year"
                binding.fechaEditText.setText("$day/${month + 1}/$year")
            })

        newFragment.show(parentFragmentManager, "datePicker")
    }

}