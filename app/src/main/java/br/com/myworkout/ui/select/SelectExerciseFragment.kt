package br.com.myworkout.ui.select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.myworkout.databinding.SelectExerciseFragmentBinding
import br.com.myworkout.ui.training.adapter.SelectExerciseAdapter

class SelectExerciseFragment: Fragment() {

    private lateinit var binding: SelectExerciseFragmentBinding
    private lateinit var adapter: SelectExerciseAdapter

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

        configureAdapter()
    }

    private fun configureAdapter() {
        binding.selectExerciseFragmentRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = SelectExerciseAdapter(mutableListOf())
        binding.selectExerciseFragmentRecyclerView.adapter = adapter
    }
}