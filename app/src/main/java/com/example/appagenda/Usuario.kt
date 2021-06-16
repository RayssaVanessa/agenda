package com.example.appagenda

import android.graphics.Bitmap

data class Usuario (val nome: String,
                                      val celular:String,
                                      val email:String,
                                      val foto: Bitmap?=null)
