package com.example.meuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Chronometer
import android.widget.TextView
import com.example.meuapp.domain.Usuario
import java.io.File

class HomeActivity : LogActivity() {
    var file: File? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val args = intent.extras
        val user = args?.getSerializable("Usuario") as Usuario

/*        tNome.text = "Olá, ${user.nome} - seu email é: ${user.email}"
        btAbrirCamera.setOnClickListener{
            onClickCamera()
        }
        if (savedInstanceState != null){
            file = savedInstanceState.getSerializable("file") as File
            shoeImage(file)

        }

        val ok = PermissionUtils.request(this, arrayOf(Mainfest.permission.CAMERA))
        if(!ok){
            btAbrirCamera.visibility = View.INVISIBLE
        }

        val chronometer = findViewById<Chronometer>(R.id.Chronometer)
        chronometer.start()
    }

    fun createFile(fileName: String): File {
        val sdCardDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        if(sdCardDir != null && sdCardDir.exists()){
            sdCardDir.mkdir()
        } */
    }
}