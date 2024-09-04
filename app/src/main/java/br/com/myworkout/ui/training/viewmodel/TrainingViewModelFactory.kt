package br.com.myworkout.ui.training.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import br.com.myworkout.repository.TrainingRepositoryImpl
import br.com.myworkout.repository.source.TrainingDataSourceImpl

class TrainingViewModelFactory(context: Context) : ViewModelProvider.Factory {
    val context = context
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val dataSource = TrainingDataSourceImpl(context = context)
        val repository = TrainingRepositoryImpl(dataSource)
        if (modelClass.isAssignableFrom(TrainingViewModel::class.java)) {
            return TrainingViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}