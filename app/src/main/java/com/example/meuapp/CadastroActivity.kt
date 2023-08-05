package com.example.meuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.meuapp.domain.CadastroModel
import com.example.meuapp.domain.CadastroService
import com.example.meuapp.extension.alert

class CadastroActivity : LogActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        findViewById<Button>(R.id.btCadastrar).setOnClickListener{
            onClickCadastrar()
        }
    }

    private fun onClickCadastrar(){
        val termosOk = findViewById<CheckBox>(R.id.btAceite).isChecked
        if(!termosOk){
            alert("Aceite os termos para continuar")
        } else{
            val model = getCadastroModel()
            val service = CadastroService()
            val ok: Boolean = service.cadastrar(model)
            if(ok){
                alert("Cadastro realizado com sucesso"){
                    finish()
                }
            } else{
                alert("Ocorreu um erro ao cadastrar")
            }
        }
    }


    private fun getCadastroModel(): CadastroModel{
        val model = CadastroModel()
        model.nome = findViewById<EditText>(R.id.tNome).text.toString()
        model.login = findViewById<EditText>(R.id.tLogin).text.toString()
        model.email = findViewById<EditText>(R.id.tEmail).text.toString()
        model.sexo = if(findViewById<RadioGroup>(R.id.radioSexo) == findViewById<RadioButton>(R.id.radio_1)) "M" else "F"
        return model
    }
}