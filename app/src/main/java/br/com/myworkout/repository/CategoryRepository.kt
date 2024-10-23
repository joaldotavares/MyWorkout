package br.com.myworkout.repository

import br.com.myworkout.data.SelectExercise

interface CategoryRepository {
    fun getCategories(): SelectExercise
}
