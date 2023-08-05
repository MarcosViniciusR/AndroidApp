package com.example.meuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.meuapp.domain.EsqueciSenhaService
import com.example.meuapp.extension.alert

class EsqueciSenhaActivity : LogActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueci_senha)

        findViewById<Button>(R.id.btEsqueciSenha).setOnClickListener{
            onClickEnviar()
        }
    }

    private fun onClickEnviar(){
        val tLogin = findViewById<TextView>(R.id.tLogin)
        val login = tLogin.text.toString()
        val service = EsqueciSenhaService()
        val ok = service.recuperarSenha(login)
        if(ok){
            alert("Sua nova senha foi enviada ao seu email"){
                finish()
            }
        } else{
            alert("Ocorreu um erro ao recuperar a senha")
        }
    }
}