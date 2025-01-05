package br.com.myworkout.data

import androidx.room.Entity
import java.io.Serializable

@Entity
data class TrainingData(
    var exercises: MutableList<Exercise> = mutableListOf()
): Serializable
