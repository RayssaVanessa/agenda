package com.example.appagenda

import	android.content.Context
import	android.view.LayoutInflater
import	android.view.View
import	android.view.ViewGroup
import android.view.ViewParent
import	android.widget.ArrayAdapter
import	android.widget.ImageView
import	android.widget.TextView

class UsuarioAdapter(context: Context): ArrayAdapter<Usuario>(context ,0) {
   	override fun	getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val	v:View
        if(convertView	!=	null){
            v	=	convertView
        }else{
            v	=	LayoutInflater.from(context).inflate(R.layout.list_view_item,	parent,	false)
        }
        val	item	=	getItem(position)
        val numTel =v.findViewById<TextView>(R.id.recebeTel)
        val refEmail = v.findViewById<TextView>(R.id.recbeEmail)
        val	txt_produto: TextView =	v.findViewById<TextView>(R.id.txt_nome_pessoa)
        val	img_pessoa	=	v.findViewById<ImageView>(R.id.img_item_foto)
        txt_produto.text	=	item?.nome
        if	(item?.foto	!=	null){
            img_pessoa.setImageBitmap(item.foto)
        }
        return	v
    }
}


