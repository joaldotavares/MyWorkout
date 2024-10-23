package br.com.myworkout.ui.select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.myworkout.commons.extensions.nonNullObserver
import br.com.myworkout.commons.extensions.showSnackBar
import br.com.myworkout.data.Category
import br.com.myworkout.data.SelectExercise
import br.com.myworkout.databinding.SelectExerciseFragmentBinding
import br.com.myworkout.ui.select.viewmodel.SelectExerciseViewModel
import br.com.myworkout.ui.select.viewmodel.SelectExerciseViewModelFactory
import br.com.myworkout.ui.state.StateError
import br.com.myworkout.ui.state.StateLoading
import br.com.myworkout.ui.state.StateSuccess
import br.com.myworkout.ui.training.TrainingFragmentDirections
import br.com.myworkout.ui.training.adapter.SelectExerciseAdapter

class SelectExerciseFragment: Fragment() {

    private val viewModel: SelectExerciseViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            SelectExerciseViewModelFactory(requireContext())
        )[SelectExerciseViewModel::class.java]
    }

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

    override fun onResume() {
        super.onResume()
        viewModel.getCategories()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.categoryViewModel.nonNullObserver(viewLifecycleOwner) {
            when (it) {
                is StateSuccess -> it.data?.let { category -> configureAdapter(category) }
                is StateError -> sendToPageError()
                else -> {}
            }
        }
    }

    private fun sendToPageError() {
        val directions = SelectExerciseFragmentDirections.actionSelectExerciseFragmentToErrorFragment()
        findNavController().navigate(directions)
    }

    private fun configureAdapter(
        it: SelectExercise
    ) {
        binding.selectExerciseFragmentRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = SelectExerciseAdapter(it.lista)
        binding.selectExerciseFragmentRecyclerView.adapter = adapter

        adapter.onItemClickListener = {
            Toast.makeText(requireContext(), it.urlToImage, Toast.LENGTH_LONG).show()
        }
    }
}