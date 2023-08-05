package com.example.meuapp.domain

import android.util.Log

class CadastroService {
    fun cadastrar(model:CadastroModel):Boolean{
        Log.d("[Aula-prog4]", "Cadatro $model")
        return true
    }
}