package br.com.myworkout.repository.source

import br.com.myworkout.data.Category

interface CategoryDataSource {

    fun getCategories(): Category
}