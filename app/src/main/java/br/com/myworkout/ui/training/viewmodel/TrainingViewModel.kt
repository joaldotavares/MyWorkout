package br.com.myworkout.ui.training.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.myworkout.data.Exercise
import br.com.myworkout.data.TrainingData
import br.com.myworkout.repository.TrainingRepository
import br.com.myworkout.ui.state.StateAction
import br.com.myworkout.ui.state.StateError
import br.com.myworkout.ui.state.StateLoading
import br.com.myworkout.ui.state.StateResponse
import br.com.myworkout.ui.state.StateSuccess
import kotlinx.coroutines.launch

class TrainingViewModel(
    private val repository: TrainingRepository
) : ViewModel() {

    private val _trainingViewModel = MutableLiveData<StateResponse<TrainingData>>()
    val trainingViewModel: LiveData<StateResponse<TrainingData>> get() = _trainingViewModel

    private val _observerState = MutableLiveData<StateAction>()
    val observerState: LiveData<StateAction> get() = _observerState

    fun getTrainings() {
        viewModelScope.launch {
            _trainingViewModel.postValue(StateLoading())
            try {
                val response = repository.getTrainingData()
                _trainingViewModel.postValue(StateSuccess(response))
            } catch (e: Exception) {
                _trainingViewModel.postValue(StateError())
            }
        }
    }

    fun manageTraining(
        id: String,
        name: String,
        series: String,
        repetitions: String,
        load: String,
        type: String,
        image: String? = null
    ) {
        val exercise = Exercise(id = id, name, series, repetitions, load, type)
        if (id.length > 5) {
            repository.addExercise(exercise)
            _observerState.value = StateAction.Update
        } else {
            repository.updateExercise(id, name, series, repetitions, load, type)
            _observerState.value = StateAction.Insert
        }
    }

    fun getSpecifyTraining(trainingType: String) {
        viewModelScope.launch {
            val responseSpecifyType = mutableListOf<Exercise>()
            _trainingViewModel.postValue(StateLoading())
            try {
                for (exercices in repository.getTrainingData()?.exercises!!) {
                    if (exercices.type == trainingType) {
                        responseSpecifyType.add(exercices)
                    }
                }
                _trainingViewModel.postValue(StateSuccess(TrainingData(responseSpecifyType)))
            } catch (e: Exception) {
                _trainingViewModel.postValue(StateError())
            }
        }
    }
}
