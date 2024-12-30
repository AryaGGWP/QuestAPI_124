package com.example.pertemuan12.di

import com.example.pertemuan12.repository.MahasiswaRepository
import com.example.pertemuan12.repository.NetworkKontakRepository
import com.example.pertemuan12.service.MahasiswaService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val kontakRepository: MahasiswaRepository
}

class MahasiswaContainer : AppContainer {
    private val baseUrl = "http://localhost/umyTI/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val mahasiswaService: MahasiswaService by lazy {
        retrofit.create(MahasiswaService::class.java) }

    override val kontakRepository: MahasiswaRepository by lazy {
        NetworkKontakRepository(mahasiswaService) }

}