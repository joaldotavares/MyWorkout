package br.com.myworkout.ui.state

sealed class StateResponse<T>

data class StateSuccess<T>(val data: T?) : StateResponse<T>()
class StateError<T> : StateResponse<T>()
class StateLoading<T> : StateResponse<T>()

sealed class StateAction {
    data object Insert : StateAction()
    data object Update : StateAction()
}