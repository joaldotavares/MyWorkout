package br.com.myworkout.ui.select.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.myworkout.data.Exercise
import br.com.myworkout.databinding.SelectCategoryFragmentBinding
import br.com.myworkout.databinding.SelectExerciseFragmentBinding
import br.com.myworkout.ui.training.adapter.SelectExerciseAdapter

class SelectExerciseFragment: Fragment() {

    private lateinit var binding: SelectExerciseFragmentBinding
    private lateinit var adapter: SelectExerciseAdapter

    private val args by navArgs<SelectExerciseFragmentArgs>()
    private var exercises = mutableListOf<Exercise>()
    private var type: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            args.category.exercises.forEach {
                exercises.add(it)
            }
        }
        type = args.category.name
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SelectExerciseFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureAdapter(exercises, type)
    }

    private fun configureAdapter(
        exercises: List<Exercise>,
        type: String
    ) {
        binding.selectFragmentRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = SelectExerciseAdapter(exercises, type)
        binding.selectFragmentRecyclerView.adapter = adapter

        adapter.onItemClickListener = {
            val directions =
                SelectExerciseFragmentDirections.actionSelectExerciseFragmentToManageTrainingFragment(it)
            findNavController().navigate(directions)
        }

    }
}