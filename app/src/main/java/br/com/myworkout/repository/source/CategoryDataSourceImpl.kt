package br.com.myworkout.repository.source

import android.content.Context
import android.content.SharedPreferences
import br.com.myworkout.data.Category
import br.com.myworkout.data.Exercise
import br.com.myworkout.data.SelectCategory
import com.google.gson.Gson
import java.util.UUID

class CategoryDataSourceImpl(
    val context: Context
) : CategoryDataSource {

    private val sharedPreferences =
        context.applicationContext.getSharedPreferences(
            TrainingDataSourceImpl.DATABASE_NAME,
            Context.MODE_PRIVATE
        )

    private val gson: Gson = Gson()

    override fun getCategories(): SelectCategory {
        return gson.fromJson(
            sharedPreferences.getString(CATEGORIES, null),
            SelectCategory::class.java
        )
    }

    private val categoryList = SelectCategory(
        listOf(
            Category(
                name = "Peitoral",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Supino Reto",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/supino_reto.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Supino Inclinado",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/supino_inclinado.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Supino Inclinado com Halter",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/supino_inclinado_com_halter.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Supino Reto com Halter",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/supino_reto_com_halter.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Voador",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/voador.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Crucifixo Inclinado com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/crucifixo_inclinado_com_halter.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Crucifixo Reto com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/crucifixo_reto_com_halter.jpg?raw=true",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/chest_category.jpg?raw=true"
            ),
            Category(
                name = "Biceps",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Direta com Barra W",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_direta_barra_w.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Direta",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_direta.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Martelo",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_martelo.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Scott",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_scott.jpg?raw=true",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/biceps_category.jpg?raw=true"
            ),
            Category(
                name = "Deltóides",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Elevação Frontal com Halter",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/elevacao_frontal_com_halter.jpg?raw=true",
                        check = false
                    ),

                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Alta com Halter",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_alta_halter.jpg?raw=true",
                        check = false
                    )
                    ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/deltoid_category.jpg?raw=true"
            ),
            Category(
                name = "Costas",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Puxada Frente",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/puxada_alta-frente.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Puxada Frente com Triângulo",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_frontal_com_triangulo.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Unilateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_unilateral.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Curvada Unilateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_curvada_unilateral.jpg?raw=true",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/back_category.jpg?raw=true"
            ),
            Category(
                name = "Abdominais",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Abdominal na Maquina",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/abdominal_maquina.jpg?raw=true",
                        check = false
                    )
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/abs_category.jpg?raw=true"
            ),
            Category(
                name = "Quadriceps",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Agachamento Livre com Barra",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/agachamento_livre_barra.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Leg Press 45 Graus",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/leg_press_45_graus.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Agachamento Bulgaro",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/agachamento_bulgaro.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Agachamento No Smith",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/agachamento_no_smith.jpg?raw=true",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/quadriceps_category.jpg?raw=true"
            ),
            Category(
                name = "Posteriores",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Mesa Flexora Vertical",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/mesa_flexora_vertical.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Panturrila em pé",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/panturrilha_em_pe_na_maquina.jpg?raw=true",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/later_category.jpg?raw=true"
            ),
            Category(
                name = "Glúteos",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Stiff com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/stiff_halters.jpg?raw=true",
                        check = false
                    ),Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Elevação Pélvica",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/elevacao_pelvica.jpg?raw=true",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/glutes_category.jpg?raw=true"
            ),
            Category(
                name = "Tríceps",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Triceps Corda",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/triceps_corda.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Triceps Pulley",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/triceps_pulley.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Extensão de Triceps no Banco com Halter",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/extensao_de_triceps_com_halter_no_banco.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Francesa Cross",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_francesa_cross.jpg?raw=true",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/triceps_category.jpg?raw=true"
            ),
        )
    )

    init {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(CATEGORIES, gson.toJson(categoryList)).apply()
    }

    companion object {
        const val CATEGORIES = "get_categories_list"
    }
}