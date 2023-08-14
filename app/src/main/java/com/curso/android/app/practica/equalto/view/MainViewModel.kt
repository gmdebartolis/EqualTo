package com.curso.android.app.practica.equalto.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.equalto.model.CadenaIngresada
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val comparar: LiveData<CadenaIngresada> get() = _comparar
    private var _comparar = MutableLiveData<CadenaIngresada>(CadenaIngresada(ingreso1="", ingreso2= "", texto = "AQUÍ VERÁS EL RESULTADO"))

    var nxt = "AQUÍ VERÁS EL RESULTADO"

    fun compararCadenas(input: CadenaIngresada) {

        if (input.ingreso1 == input.ingreso2) {
            nxt = "Las cadenas de texto son iguales"
            updateString(nxt)
        } else {
            nxt = "Las cadenas de texto son diferentes"
            updateString(nxt)
        }
    }

    private fun updateString(nxt: String) {
        viewModelScope.launch {
            _comparar.value = CadenaIngresada(ingreso1="",ingreso2="", texto = nxt)
        }
    }
}