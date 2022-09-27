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
    var selectedDia: Int = 0
    var selectedMes: Int = 0
    var selectedAño: Int = 0
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
            if (selectedDia == 0 && selectedMes == 0 && selectedAño == 0) {
                binding.fechaEditText.error = "Hubo un error este campo es obligatorio"
                return@setOnClickListener
            }
            if (prestamo == "") {
                binding.prestamoEditText.error = "Hubo un error este campo es obligatorio"
                return@setOnClickListener
            }
            if (plazoTotal == "") {
                binding.plazoTotalEditText.error = "Hubo un error este campo es obligatorio"
                return@setOnClickListener
            }
            findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                    dia = selectedDia,
                    mes = selectedMes,
                    year = selectedAño,
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
                selectedDia = day
                selectedMes = month
                selectedAño = year
                binding.fechaEditText.setText("$day/${month + 1}/$year")
            })

        newFragment.show(parentFragmentManager, "datePicker")
    }

}