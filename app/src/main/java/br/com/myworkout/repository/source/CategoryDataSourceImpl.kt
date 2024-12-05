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
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Crossover na Polia Alta",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/crossover_polia_alta.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Flexão de Braço",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/flexao_braco.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Pullover com Halter",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/pullover_com_halter.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Crossover na Polia Baixa",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/crossover_na_polia_baixa.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Supino Vertical Articulado",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/supino_vertical_articulado.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Pullover",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/pullover.jpg?raw=true",
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
                        name = "Rosca Concentrada",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_concentrada.jpg?raw=true",
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
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Martelo no Scott",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_martelo_scott.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Scott Unilateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_scott_unilateral.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Alternada Inclinado",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_alternada_inclinada.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Martelo no Banco",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_martelo_banco.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Biceps na Polia",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_biceps_na_polia.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Martelo Unilateral no Scott",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_martelo_unilateral_scott.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Direta na Polia com Corda",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/biceps_polia_com_corda.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Direta na Polia com Barra",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_direta_na_polia.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca Unilateral na Polia",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_unilateral_na_polia.jpg?raw=true",
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
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Crucifixo Invertido",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/crucifixo_invertido.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Alta na Polia",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_alta_na_polia.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Manguito Rotador",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/manguito_rotador.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Desenvvolvimento com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/desenvolvimento_com_halters.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Elevação Frontal com Anilha",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/elevacao_frontal_com_anilha.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Elevação Frontal Unilateral com Halter",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/elevacao_frontal_unilateral_com_halter.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Encolhimento de Ombro com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/encolhimento_de_ombros_com_halter.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Elevação Lateral Unilateral na Polia",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/elevacao_lateral_na_polia.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Desenvolvimento Articulado",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/desenvolvimento_articulado.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Desenvolvimento Sentado com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/desenvolvimento_com_halters_sentado.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Elevação Lateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/elavacao_lateral.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Alta com Barra",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_alta_com_barra.jpg?raw=true",
                        check = false
                    ),
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
                        name = "Remada Curvada na Polia Baixa",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada-curvada-supinada-polia-baixa.jpg?raw=true",
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
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Puxada Alta Unilateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/puxada_unilateral.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Inclinada no Banco com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_inclinada_no_banco_com_halters.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Barra Fixa Pull Up",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/barra_fixa_pull_up.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Curva com Barra",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_curvada_com_barra.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Curva com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_curvada_com_halter.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Voador Dorsal",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/voador_dorsal.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Puxada Articulada",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/puxada_articulada.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Depressão Sagital",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/depressao_sagital.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada com Corda na Polia Alta",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_com_corda_polia.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Articulada",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_articulada.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Remada Baixa com Triângulo",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/remada_baixa_com_triangulo.jpg?raw=true",
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
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Abdominal Oblíquo com Anilha",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/abdominal_oblicuo_com_anilha.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Abdominal Livre",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/abdonimal_livre.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Prancha com Elevação de Pernas",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/prancha_com_elevacao_de_pernas.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Prancha Tocando os Ombros",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/prancha_tocando_ombros.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Prancha Cachorrinho Isométrico",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/prancha_cachorrinho_isometrica.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Roda Abdominal",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/roda_abdominal.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Prancha Dinâmica",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/prancha_dinamica.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Prancha Escalador",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/prancha_escalador.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Prancha Lateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/prancha_lateral.jpg?raw=true",
                        check = false
                    ),
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
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Agachamento com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/agachamento_com_halter.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Agachamento Sumo com Barra",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/agachamento_sumo_com_barra.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Cadeira Extensora",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/cadeira_extensora.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Cadeira Extensora Unilateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/cadeira_extensora_unilateral.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Agachamento Hack 45 Graus",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/agachamento_hack_45_graus.jpg?raw=true",
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
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Cadeira Abdutora",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/cadeira_abdutora.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Cadeira Adutora",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/cadeira_adutora.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Mesa Flexora",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/mesa_flexora.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Panturrilha Sentado",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/gemeos_sentado_na_maquina.jpg?raw=true",
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
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Elevação Pélvica",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/elevacao_pelvica.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Abdução de Quadril na Polia",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/abducao_de_quadril_na_polia.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Agachamento Terra",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/agachamento_terra.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Coice na Polia",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/coice_na_polia.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Abdução de Quadril",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/abducao_de_quadril.jpg?raw=true",
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
                        name = "Extensão de Triceps Deitado com Halter",
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
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Extensão de Triceps Deitado com Barra",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/extens%C3%A3o_triceps_deitado.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Mergulho Profundo com Aparelho",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/triceps_mergulho_profundo_com_aparelho.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Triceps Coice Unilateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/triceps_coice_unilatel.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Triceps Francês Unilateral",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/triceps_frances_unilateral.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Triceps Unilateral na Polia",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/triceps_unilateral_polia.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Triceps Francês Sentado com Halter",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/triceps_frances_sentado_com_halter.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Triceps na Paralela",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/triceps_na_paralela.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Triceps Francês Unilateral Sentado",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/triceps_frances_unilateral_sentado.jpg?raw=true",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/triceps_category.jpg?raw=true"
            ),
            Category(
                name = "Antebraço",
                exercises = listOf(
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca de Punho",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_de_punho.jpg?raw=true",
                        check = false
                    ),
                    Exercise(
                        id = UUID.randomUUID().toString(),
                        name = "Rosca de Punho com Halters",
                        series = "",
                        repetitions = "",
                        load = "",
                        type = "",
                        image = "https://github.com/joaldotavares/Images/blob/main/Exercicios/rosca_punho_com_halters.jpg?raw=true",
                        check = false
                    ),
                ),
                urlToImage = "https://github.com/joaldotavares/Images/blob/main/categorias/antebrachial_category.jpg?raw=true"
            )
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
