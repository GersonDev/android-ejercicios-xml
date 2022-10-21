package com.example.android_ejercicios_xml.presentation.activities.main.fragments.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.*
import com.example.android_ejercicios_xml.services.EnviarMensajeWorker
import com.example.android_ejercicios_xml.databinding.FragmentSecondBinding
import com.example.android_ejercicios_xml.domain.models.Mensaje
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    val secondFragmentViewModel: SecondFragmentViewModel by inject()

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mensajeAdapter = MensajeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configurarRecyclerView()

        secondFragmentViewModel.getMensajes()

        secondFragmentViewModel.mensajesLiveData.observe(
            viewLifecycleOwner,
            Observer { mensajeDelServidor ->
                mensajeAdapter.agregarMensajes(mensajeDelServidor)
            })

        secondFragmentViewModel.mensajesDelServidor.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        })


        binding.enviarMensajeImagenButton.setOnClickListener {
            val mensaje = binding.mensajeEditTextMultiline.text.toString()
            secondFragmentViewModel.enviarMensaje(mensaje = mensaje)
            mensajeAdapter.agregarMensajes(Mensaje(mensaje = mensaje))
        }

        binding.regresaButton.setOnClickListener {
            findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToFirstFragment())
        }
        binding.swipeRefresh.setOnRefreshListener {
            secondFragmentViewModel.getMensajes()
            binding.swipeRefresh.isRefreshing = false
        }

        binding.workManaherImagButon.setOnClickListener {
            // obtenemos el mensaje desde la vista
            val mensaje = binding.mensajeEditTextMultiline.text.toString()

            // valor a enviar
            val data = Data.Builder()
                .putString("mensaje_llave", mensaje)
                .build()

            // creamos el request
            val uploadWorkRequest: WorkRequest =
                OneTimeWorkRequestBuilder<EnviarMensajeWorker>()
                    .setInputData(data)
                    .build()

            //enviamos el request al sistema
            val workManager = WorkManager.getInstance(requireContext())
            workManager.enqueue(uploadWorkRequest)

        }
    }

    private fun configurarRecyclerView() {
        binding.recyclerView.adapter = mensajeAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}