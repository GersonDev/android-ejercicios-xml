package com.example.android_ejercicios_xml.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_ejercicios_xml.data.database.entities.CuentaEntity

@Dao
interface CuentasDao {

    @Query("SELECT * FROM cuentas")
    suspend fun getCuentas(): List<CuentaEntity>

    @Insert
    suspend fun insertCuentas(cuentaEntity: CuentaEntity)
}
