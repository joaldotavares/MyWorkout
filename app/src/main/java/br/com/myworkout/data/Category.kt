package br.com.myworkout.data

import java.io.Serializable

data class Category(
    val name: String,
    val exercises: MutableList<Exercise>
): Serializable
