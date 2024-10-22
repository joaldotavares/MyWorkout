package br.com.myworkout.data

import java.io.Serializable

data class Category(
    val name: String,
    val exercises: List<Exercise>,
    val urlToImage: String
): Serializable
