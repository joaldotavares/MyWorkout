package br.com.myworkout.ui.select.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import br.com.myworkout.repository.CategoryRepositoryImpl
import br.com.myworkout.repository.source.CategoryDataSourceImpl

class SelectExerciseViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val dataSource = CategoryDataSourceImpl(context = context)
        val repository = CategoryRepositoryImpl(dataSource)
        if (modelClass.isAssignableFrom(SelectExerciseViewModel::class.java)) {
            return SelectExerciseViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
