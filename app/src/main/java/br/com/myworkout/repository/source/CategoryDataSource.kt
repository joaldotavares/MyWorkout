package br.com.myworkout.repository.source

import br.com.myworkout.data.Category
import br.com.myworkout.data.SelectCategory

interface CategoryDataSource {

    fun getCategories(): SelectCategory
}
