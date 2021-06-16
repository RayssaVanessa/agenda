package com.example.appagenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*




class MainActivity : AppCompatActivity() {
    lateinit var botaoAdicionar:Button
    lateinit var campoLista: ListView
    lateinit var botaoFiltrar: SearchView
    private var listaFuncionario: ArrayList<String> = arrayListOf()

    val funcionarioAdapter by lazy { ArrayAdapter<String>(this, android.R.layout.simple_list_item_1) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoAdicionar = findViewById(R.id.btn_adicionar)
        campoLista = findViewById(R.id.lista)
        botaoFiltrar = findViewById(R.id.sv_pesquisar)

        botaoAdicionar.setOnClickListener {
            val	intent	=	Intent(this,	CadastroActivity::class.java)
            startActivity(intent)

        }

        botaoFiltrar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                botaoFiltrar.clearFocus()
                if (listaFuncionario.contains(query)) {
                    funcionarioAdapter.clear()
                    funcionarioAdapter.addAll(listaFuncionario.filter { it == query })
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.Itemnaoencontrado), Toast.LENGTH_LONG).show()
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





