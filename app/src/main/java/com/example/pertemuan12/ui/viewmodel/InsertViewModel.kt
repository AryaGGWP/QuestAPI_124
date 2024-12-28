package com.example.pertemuan12.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pertemuan12.repository.MahasiswaRepository

class InsertViewModel(private val mhs: MahasiswaRepository): ViewModel() {
    var uiState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertMhsState(insert)
}