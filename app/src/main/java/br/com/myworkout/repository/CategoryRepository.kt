package br.com.myworkout.repository

import br.com.myworkout.data.Category

interface CategoryRepository {
    fun getCategories(): Category
}
