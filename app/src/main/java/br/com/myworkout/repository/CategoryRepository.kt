package br.com.myworkout.repository

import br.com.myworkout.data.SelectCategory

interface CategoryRepository {
    fun getCategories(): SelectCategory
}
