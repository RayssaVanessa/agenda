package com.example.appagenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.core.view.contains


class MainActivity : AppCompatActivity() {
    lateinit var campoNome: EditText
    lateinit var campoCelular: EditText
    lateinit var campoEmail: EditText
    lateinit var campoLista: ListView
    lateinit var botaoSalvar: Button
    lateinit var botaoFiltrar: SearchView
    lateinit var grupo: RadioGroup
    lateinit var pessoal: RadioButton
    lateinit var profissional: RadioButton
    private var listaFuncionario: ArrayList<String> = arrayListOf()

    val funcionarioAdapter by lazy { ArrayAdapter<String>(this, android.R.layout.simple_list_item_1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNome = findViewById(R.id.cpNome)
        campoCelular = findViewById(R.id.cpCel)
        campoEmail = findViewById(R.id.cpEmail)
        campoLista = findViewById(R.id.lista)
        botaoSalvar = findViewById(R.id.btnSalvar)
        botaoFiltrar = findViewById(R.id.sv_pesquisar)
        grupo = findViewById(R.id.radioGroup)
        pessoal = findViewById(R.id.btnPessoal)
        profissional = findViewById(R.id.btnProfissional)


        campoLista.adapter = funcionarioAdapter

        botaoSalvar.setOnClickListener {
            val nome = campoNome.text.toString()
            val celular = campoCelular.text.toString()
            val email = campoEmail.text.toString()

            if (nome.isNotEmpty() && celular.isNotEmpty() && email.isNotEmpty()) {
                listaFuncionario.add("$nome - $email \n $celular")
                atualizarLista()
                campoNome.text.clear()
                campoCelular.text.clear()
                campoEmail.text.clear()
            } else {
                campoNome.error = "Por favor digite um nome!"
                campoCelular.error = "Por favor, digite um contato!"
                campoEmail.error = "Por favor, digite um email!"
            }

        }
        botaoFiltrar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                botaoFiltrar.clearFocus()
                if (listaFuncionario.contains(query)) {
                    funcionarioAdapter.clear()
                    funcionarioAdapter.addAll(listaFuncionario.filter { it == query })
                } else {
                    Toast.makeText(this@MainActivity, "Item não encontrado !", Toast.LENGTH_LONG).show()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                funcionarioAdapter.filter.filter(newText)
                return false
            }
        })
    }

    //atualizar a minha lista depois de gravar um objeto
    fun atualizarLista() {
        funcionarioAdapter.clear()
        listaFuncionario.sort()
        funcionarioAdapter.addAll(listaFuncionario)
    }


}


