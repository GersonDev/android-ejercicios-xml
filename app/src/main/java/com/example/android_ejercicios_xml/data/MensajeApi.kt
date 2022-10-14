package com.example.android_ejercicios_xml.data

import com.example.android_ejercicios_xml.data.requests.MensajeRequest
import com.example.android_ejercicios_xml.data.responses.GetMensajeReponse
import com.example.android_ejercicios_xml.data.responses.PostMensajeReponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface MensajeApi {
    @GET("mensajes")
    suspend fun getMensajes(): List<GetMensajeReponse>

    @POST("mensajes")
    suspend fun createBrand(
        @Body branRequest: MensajeRequest
    ): PostMensajeReponse

    @PUT
    suspend fun updateBrand()

    @DELETE
    suspend fun deleteBrand()
}