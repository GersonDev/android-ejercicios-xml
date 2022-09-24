package com.example.android_ejercicios_xml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_ejercicios_xml.databinding.FragmentSecondBinding
import com.example.android_ejercicios_xml.domain.models.Cronograma

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    val args: SecondFragmentArgs by navArgs()

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val seguros:Double= 21.80
        binding.cronogramaRecyclerView.adapter = CronogramaAdapter(
            listOf(
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0),
                Cronograma(vencimiento = "${args.fecha}", amortizacion = 0.0, interes = 0.0, seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0)


            )
        )

        binding.cronogramaRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}