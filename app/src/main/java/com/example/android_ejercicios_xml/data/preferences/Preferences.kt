package com.example.android_ejercicios_xml.data.preferences

import android.content.Context

class Preferences(val context: Context) {

   private val SHARED_PREFERENCES_NAME:String = "Preferencias_de_Gerson"
   private val USER_ID_KEY:String = "USER_ID"

   private val storage = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0)

    fun saveDNI(dni: Int) {
        storage.edit().putInt(USER_ID_KEY, dni).apply()
    }

    fun getdni(): Int {
        return storage.getInt(USER_ID_KEY, 0)
    }
    fun saveNumeroDeCuenta(NumeroDeCuenta: Int) {
        storage.edit().putInt(USER_ID_KEY, NumeroDeCuenta).apply()
    }

    fun getNumeroDeCuenta(): Int {
        return storage.getInt(USER_ID_KEY, 0)
    }
}