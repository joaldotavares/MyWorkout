package br.com.myworkout.ui.training

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.myworkout.R
import br.com.myworkout.data.Exercise
import br.com.myworkout.databinding.ExercisesItemBinding
import br.com.myworkout.ui.training.ManageTrainingFragment.Companion.UPDATE
import br.com.myworkout.ui.training.viewmodel.TrainingViewModel

class TrainingAdapter(
    private val exercises: MutableList<Exercise>,
    private val viewModel: TrainingViewModel
) : RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder>() {

    private lateinit var binding: ExercisesItemBinding

    var onItemClickListener: (exercise: Exercise) -> Unit = {}
    var onItemEditClickListener: (exercise: Exercise) -> Unit = {}

    class TrainingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.exercises_item_name)
        val series: TextView = itemView.findViewById(R.id.exercises_item_series_value)
        val repetitions: TextView = itemView.findViewById(R.id.exercises_item_repetitions_value)
        val load: TextView = itemView.findViewById(R.id.exercises_item_load_value)
        val type: TextView = itemView.findViewById(R.id.exercises_item_name)
        val edit: ImageView = itemView.findViewById(R.id.exercises_item_edit)
        val check: CheckBox = itemView.findViewById(R.id.exercises_item_check_box)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        binding = ExercisesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrainingViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

    fun removeExerciseOnPosition(position: Int) {
        viewModel.deleteExercise(exercises[position])
        exercises.remove(exercises[position])
        notifyItemRemoved(position)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val training = exercises[position]
        holder.name.text = training.name
        holder.series.text = training.series
        holder.repetitions.text = training.repetitions
        holder.load.text = training.load
        holder.check.isChecked = training.check


        holder.check.setOnCheckedChangeListener { _, isChecked ->
            viewModel.manageTraining(
                id = training.id,
                name = training.name,
                series = training.series,
                repetitions = training.repetitions,
                load = training.load,
                type = training.type,
                isCheck = isChecked,
                state = UPDATE
            )
        }

        holder.edit.setOnClickListener {
            onItemEditClickListener(training)
        }

        holder.itemView.setOnClickListener {
            onItemClickListener(training)
        }

    }
}
