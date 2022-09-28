package com.example.android_ejercicios_xml

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
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
        val seguros: Double = 21.80
        val amortizacion = args.prestamo / args.plazoTotal
        val interes = (args.prestamo * 0.17) / 12
        val cuota = amortizacion + interes + seguros
//       binding.cronogramaRecyclerView.adapter = CronogramaAdapter(listOf(Cronograma(vencimiento = "${args.fecha}",amortizacion = args.prestamo/args.plazoTotal, interes = 0.0, seguros = seguros, subvencion = 0.0, cuota = 0.0, saldo = 0.0)))

        val lista = mutableListOf<Cronograma>()
        var acumulador = 0
        var acumulador2 = 0f
        for (i in 1..args.plazoTotal) {
            acumulador += 1
            acumulador2 += amortizacion
            lista.add(
                Cronograma(
                    vencimiento = "${args.dia}/${args.mes + acumulador}/${args.year}",
                    amortizacion = amortizacion,
                    interes = interes,
                    seguros = seguros,
                    subvencion = 0.0,
                    cuota = cuota,
                    saldo = args.prestamo - acumulador2
                )
            )
        }
        var totalDeInteres = lista.sumByDouble {
            it.interes
        }
        var totalDeCuotas = lista.sumByDouble {
            it.cuota
        }

        lista.add(
            Cronograma(
                vencimiento = "TOTALES",
                amortizacion = args.prestamo,
                interes = totalDeInteres,
                seguros = seguros,
                subvencion = 0.0,
                cuota = totalDeCuotas,
                saldo = 0f

            )
        )
        binding.cronogramaRecyclerView.adapter = CronogramaAdapter(lista)

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