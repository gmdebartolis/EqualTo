package com.curso.android.app.practica.equalto.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.curso.android.app.practica.equalto.databinding.ActivityMainBinding
import com.curso.android.app.practica.equalto.model.CadenaIngresada

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolbar: Toolbar = binding.barra
        setSupportActionBar(toolbar)

        binding.textoResultado.text = mainViewModel.nxt


        mainViewModel.comparar.observe(this) {comparar ->
            binding.textoResultado.text = mainViewModel.comparar.value?.texto
        }


        binding.botonComparar.setOnClickListener {
            val ingreso1 = binding.inputUno.text.toString()
            val ingreso2 = binding.inputDos.text.toString()

            val input = CadenaIngresada(ingreso1,ingreso2,texto="")
            mainViewModel.compararCadenas(input)
        }
    }
}