package br.com.myworkout.repository.source

import br.com.myworkout.data.Category
import br.com.myworkout.data.SelectExercise

interface CategoryDataSource {

    fun getCategories(): SelectExercise
}
