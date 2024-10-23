package br.com.myworkout.ui.training.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.myworkout.R
import br.com.myworkout.data.Category
import br.com.myworkout.databinding.SelectCategoryItemBinding
import com.bumptech.glide.Glide

class SelectCategoryAdapter(
    private val categories: List<Category>
) : RecyclerView.Adapter<SelectCategoryAdapter.SelectExerciseViewHolder>() {

    private lateinit var binding: SelectCategoryItemBinding
    var onItemClickListener: (exercise: Category) -> Unit = {}

    class SelectExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.select_exercise_item_image)
        val name: TextView = itemView.findViewById(R.id.select_exercise_item_name)
        val exercises: TextView = itemView.findViewById(R.id.select_exercise_item_qtd)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectExerciseViewHolder {
        binding =
            SelectCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectExerciseViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: SelectExerciseViewHolder, position: Int) {
        val category = categories[position]
        binding.category = category
        holder.name.text = category.name
        holder.exercises.text = category.exercises.size.toString()
        Glide.with(holder.itemView.context).load(category.urlToImage).into(holder.image)

        holder.itemView.setOnClickListener {
            onItemClickListener(category)
        }
    }
}
