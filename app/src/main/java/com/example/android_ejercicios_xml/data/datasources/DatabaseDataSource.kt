package com.example.android_ejercicios_xml.data.datasources

import android.content.Context
import com.example.android_ejercicios_xml.data.database.entities.ClienteEntity
import com.example.android_ejercicios_xml.data.database.entities.CuentaEntity
import com.example.android_ejercicios_xml.data.database.entities.LineaUnoDataBase
import com.example.android_ejercicios_xml.data.database.entities.MovimientoEntity
import com.example.android_ejercicios_xml.domain.models.Cliente
import com.example.android_ejercicios_xml.domain.models.Cuenta
import com.example.android_ejercicios_xml.domain.models.Movimiento

class DatabaseDataSource {
    suspend fun getAllTheClientes(context: Context): List<Cliente> {
        val listOfClienteEntities = LineaUnoDataBase.buildDatabase(context)
            .clientesDao()
            .getClientes()
        return listOfClienteEntities.map {
            Cliente(
                dni = it.dni,
                nombreCliente = it.nombreCliente,
                direccion = it.direccion,
                distrito = it.distrito
            )
        }
    }

    suspend fun insertCliente(context: Context, cliente: Cliente) {
        val clienteEntity = ClienteEntity(
            dni = cliente.dni,
            nombreCliente = cliente.nombreCliente,
            direccion = cliente.direccion,
            distrito = cliente.distrito
        )
        LineaUnoDataBase.buildDatabase(context)
            .clientesDao()
            .insertCliente(clienteEntity)
    }

    suspend fun getAllTheCuentas(context: Context): List<Cuenta> {
        val listOfCuentaEntities = LineaUnoDataBase.buildDatabase(context)
            .cuentasDao()
            .getCuentas()
        return listOfCuentaEntities.map {
            Cuenta(
                numeroDeCuenta = it.numeroDeCuenta,
                tipoDeCuenta = it.tipoDeCuenta,
                moneda = it.moneda,
                saldoActual = it.saldoActual,
                dni = it.dni

            )
        }
    }

    suspend fun insertCuenta(context: Context, cuenta: Cuenta) {
        val cuentaEntity = CuentaEntity(
            numeroDeCuenta = cuenta.numeroDeCuenta,
            tipoDeCuenta = cuenta.tipoDeCuenta,
            moneda = cuenta.moneda,
            saldoActual = cuenta.saldoActual,
            dni = cuenta.dni
        )
        LineaUnoDataBase.buildDatabase(context)
            .cuentasDao()
            .insertCuentas(cuentaEntity)
    }

    suspend fun getAllMovimientos(context: Context): List<Movimiento> {
        val listOfMovimientos = LineaUnoDataBase.buildDatabase(context)
            .movimientosDao()
            .getMovimientos()
        return listOfMovimientos.map {
            Movimiento(
                numeroDeCuenta = it.numeroDeCuenta,
                fechaOperacion = it.fechaOperacion,
                descripcion = it.descripcion,
                numeroDeOperacion = it.numeroDeOperacion,
                tipoDeOperacion = it.tipoDeOperacion,
                importe = it.importe,
                saldoContable = it.saldoContable
            )
        }
    }

    suspend fun insertMovimieto(context: Context, movimiento: Movimiento) {
        val movimientoEntity = MovimientoEntity(
            numeroDeCuenta = movimiento.numeroDeCuenta,
            fechaOperacion = movimiento.fechaOperacion,
            descripcion = movimiento.descripcion,
            numeroDeOperacion = movimiento.numeroDeOperacion,
            tipoDeOperacion = movimiento.tipoDeOperacion,
            importe = movimiento.importe,
            saldoContable = movimiento.saldoContable
        )
        LineaUnoDataBase.buildDatabase(context)
            .movimientosDao()
            .insertMovimientos(movimientoEntity)
    }
}
