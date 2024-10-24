package br.com.myworkout.ui.training.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.myworkout.R
import br.com.myworkout.data.Exercise
import br.com.myworkout.databinding.SelectExerciseItemBinding
import com.bumptech.glide.Glide

class SelectExerciseAdapter(
    private val exercise: List<Exercise>,
    private val categoryName: String
) : RecyclerView.Adapter<SelectExerciseAdapter.SelectExerciseViewHolder>() {

    private lateinit var binding: SelectExerciseItemBinding
    var onItemClickListener: (exercise: Exercise) -> Unit = {}

    class SelectExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.select_image)
        val name: TextView = itemView.findViewById(R.id.select_name)
        val type: TextView = itemView.findViewById(R.id.select_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectExerciseViewHolder {
        binding =
            SelectExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectExerciseViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return exercise.size
    }

    override fun onBindViewHolder(holder: SelectExerciseViewHolder, position: Int) {
        val exercise = exercise[position]

        holder.name.text = exercise.name
        holder.type.text = categoryName
        Glide.with(holder.itemView.context).load(exercise.image).into(holder.image)

        holder.itemView.setOnClickListener {
            onItemClickListener(exercise)
        }
    }

}