package br.com.myworkout.ui.select.category.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import br.com.myworkout.repository.CategoryRepositoryImpl
import br.com.myworkout.repository.source.CategoryDataSourceImpl

class SelectCategoryViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        val dataSource = CategoryDataSourceImpl(context = context)
        val repository = CategoryRepositoryImpl(dataSource)
        if (modelClass.isAssignableFrom(SelectCategoryViewModel::class.java)) {
            return SelectCategoryViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
