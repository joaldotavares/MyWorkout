package br.com.myworkout.repository

import br.com.myworkout.data.Category
import br.com.myworkout.repository.source.CategoryDataSource

class CategoryRepositoryImpl(
    private val dataSource: CategoryDataSource
) : CategoryRepository {
    override fun getCategories(): Category {
        return dataSource.getCategories()
    }


}