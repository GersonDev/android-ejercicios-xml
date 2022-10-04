package com.example.android_ejercicios_xml.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android_ejercicios_xml.data.database.entities.MovimientoEntity
import com.example.android_ejercicios_xml.domain.models.Movimiento

@Dao
interface MovimientosDao {
@Query("SELECT * FROM movimientos")
suspend fun getMovimientos(): List<Movimiento>
@Insert
suspend fun insertMovimientos(movimientoEntity: MovimientoEntity)
}