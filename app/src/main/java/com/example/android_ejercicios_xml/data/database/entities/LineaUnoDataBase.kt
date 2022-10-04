package com.example.android_ejercicios_xml.data.database.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_ejercicios_xml.data.database.dao.ClientesDao
import com.example.android_ejercicios_xml.data.database.dao.CuentasDao
import com.example.android_ejercicios_xml.data.database.dao.MovimientosDao


@Database(entities = [ClienteEntity::class, CuentaEntity::class,MovimientoEntity::class], version = 1, exportSchema = false)
abstract class LineaUnoDataBase : RoomDatabase() {

    abstract fun clientesDao(): ClientesDao
    abstract fun cuentasDao(): CuentasDao
    abstract fun movimientosDao():MovimientosDao

    companion object {

        fun buildDatabase(context: Context): LineaUnoDataBase {
            return Room.databaseBuilder(context, LineaUnoDataBase::class.java, "Banco")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}