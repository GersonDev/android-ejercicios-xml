package com.example.android_ejercicios_xml.data.database.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_ejercicios_xml.data.database.dao.ClientesDao
import com.example.android_ejercicios_xml.data.database.entities.ClienteEntity


@Database(entities = [ClienteEntity::class], version = 1, exportSchema = false)
abstract class LineaUnoDataBase : RoomDatabase() {

    abstract fun clientesDao(): ClientesDao

    companion object {

        fun buildDatabase(context: Context): LineaUnoDataBase {
            return Room.databaseBuilder(context, LineaUnoDataBase::class.java, "LineaUnoDatabase")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}