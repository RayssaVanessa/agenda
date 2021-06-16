package com.example.appagenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class CadastroActivity : AppCompatActivity() {

    lateinit var campoNome: EditText
    lateinit var campoCelular: EditText
    lateinit var campoEmail: EditText
    lateinit var botaoSalvar: Button
    lateinit var radio: RadioGroup
    lateinit var refPessoal: RadioButton
    lateinit var refTrabalho: RadioButton
    private var listaFuncionario: ArrayList<String> = arrayListOf()
    lateinit var imagem:ImageView
    val funcionarioAdapter by lazy { ArrayAdapter<String>(this, android.R.layout.simple_list_item_1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)


        campoNome = findViewById(R.id.cpNome)
        campoCelular = findViewById(R.id.cpCel)
        campoEmail = findViewById(R.id.cpEmail)
        botaoSalvar = findViewById(R.id.btnSalvar)
        radio = findViewById(R.id.radioGroup)
        refPessoal = findViewById(R.id.radioPessoal)
        refTrabalho = findViewById(R.id.radioTrabalho)
        imagem = findViewById(R.id.img_foto_produto)

        botaoSalvar.setOnClickListener {

            val nome = campoNome.text.toString()
            val celular = campoCelular.text.toString()
            val email = campoEmail.text.toString()

            if (nome.isNotEmpty() && celular.isNotEmpty() && email.isNotEmpty()) {
                val list = Usuario(nome,celular.toString(),email.toString(),)
                listaGlobal.add(list)
                // funcao para atualizar lista e ordernar
                campoNome.text.clear()
                campoCelular.text.clear()
                campoEmail.text.clear()
            } else {
                campoNome.error = getString(R.string.digiteUmNome)
                campoCelular.error = getString(R.string.ErroCelular)
                campoEmail.error = getString(R.string.ErroEmail)


            }

        }

    }



}