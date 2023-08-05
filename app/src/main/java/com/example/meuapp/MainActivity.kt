package com.example.meuapp


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.TextView
import com.example.meuapp.domain.LoginService
import com.example.meuapp.extension.alert

class MainActivity : LogActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState != null){
            Log.d("ciclo de vida", "recuperando estado")
            count = savedInstanceState.getInt("count")
        }

        findViewById<Button>(R.id.btLogin).setOnClickListener{
            onClickLogin()
        }

        findViewById<TextView>(R.id.btEsqueciSenha).setOnClickListener {
            startActivity(Intent(this,EsqueciSenhaActivity::class.java))
        }

        findViewById<TextView>(R.id.btCadastrar).setOnClickListener{
            startActivity(Intent(this,CadastroActivity::class.java))
        }

        findViewById<TextView>(R.id.btLocalizar).setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
        }

    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        Log.d("ciclo de vida", "Salvando estado")
        count ++
        outState.putInt("count", count)
    }


    private fun onClickLogin() {
        //pega as infos das views e armazena em constantes
        val tLogin = findViewById<TextView>(R.id.tLogin)
        val tSenha = findViewById<TextView>(R.id.tSenha)

        //ler os textos
        val login = tLogin.text.toString()
        val senha = tSenha.text.toString()
        val service = LoginService()
        val user = service.login(login, senha)
        if(user != null){
            //startActivity(Intent(this, HomeActivity::class.java))
            finish()
            val Intent = Intent(this, HomeActivity::class.java)
            val args = Bundle()
            args.putSerializable("Usuario", user)
            intent.putExtras(args)
            startActivity(intent)
        } else{
            alert("Login Incorreto, tente novamente")
        }
    }



    //teste de comentário
}