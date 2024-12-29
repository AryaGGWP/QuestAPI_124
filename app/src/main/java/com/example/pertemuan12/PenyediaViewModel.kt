package com.example.pertemuan12

import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan12.ui.viewmodel.HomeViewModel
import com.example.pertemuan12.ui.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiKontak().container.kontakRepository) }
        initializer { InsertViewModel(aplikasiKontak().container.kontakRepository) }
    }
    fun CreationExtras.aplikasiKontak(): MahasiswaApplications =
        (this[viewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)
}
