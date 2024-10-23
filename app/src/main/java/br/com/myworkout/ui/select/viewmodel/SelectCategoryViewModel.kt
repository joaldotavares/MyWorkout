package br.com.myworkout.ui.select.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.myworkout.data.SelectCategory
import br.com.myworkout.repository.CategoryRepository
import br.com.myworkout.ui.state.StateError
import br.com.myworkout.ui.state.StateLoading
import br.com.myworkout.ui.state.StateResponse
import br.com.myworkout.ui.state.StateSuccess
import kotlinx.coroutines.launch

class SelectCategoryViewModel(
    private val repository: CategoryRepository
) : ViewModel() {

    private val _categoryViewModel = MutableLiveData<StateResponse<SelectCategory>>()
    val categoryViewModel: LiveData<StateResponse<SelectCategory>> get() = _categoryViewModel

    fun getCategories() {
        viewModelScope.launch {
            _categoryViewModel.value = StateLoading()

            try {
                val categories = repository.getCategories()
                _categoryViewModel.postValue(StateSuccess(categories))
            } catch (e: Exception) {
                _categoryViewModel.postValue(StateError())
            }
        }
    }
}