package br.com.myworkout.ui.training.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.myworkout.data.Category
import br.com.myworkout.databinding.SelectExerciseItemBinding

class SelectExerciseAdapter(
    private val categories: List<Category>
) : RecyclerView.Adapter<SelectExerciseAdapter.SelectExerciseViewHolder>() {

    private lateinit var binding: SelectExerciseItemBinding
    var onItemClickListener: (exercise: Category) -> Unit = {}

    class SelectExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectExerciseViewHolder {
        binding =
            SelectExerciseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectExerciseViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: SelectExerciseViewHolder, position: Int) {
        val category =categories[position]


        holder.itemView.setOnClickListener {
            onItemClickListener(category)
        }
    }


}