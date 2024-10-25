package br.com.myworkout.ui.select.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.myworkout.commons.extensions.nonNullObserver
import br.com.myworkout.data.SelectCategory
import br.com.myworkout.databinding.SelectCategoryFragmentBinding
import br.com.myworkout.ui.select.category.viewmodel.SelectCategoryViewModel
import br.com.myworkout.ui.select.category.viewmodel.SelectCategoryViewModelFactory
import br.com.myworkout.ui.state.StateError
import br.com.myworkout.ui.state.StateSuccess
import br.com.myworkout.ui.training.adapter.SelectCategoryAdapter

class SelectCategoryFragment : Fragment() {

    private val viewModel: SelectCategoryViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            SelectCategoryViewModelFactory(requireContext())
        )[SelectCategoryViewModel::class.java]
    }

    private lateinit var binding: SelectCategoryFragmentBinding
    private lateinit var adapter: SelectCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SelectCategoryFragmentBinding.inflate(inflater, container, false)
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
        val directions =
            SelectCategoryFragmentDirections.actionSelectExerciseFragmentToErrorFragment()
        findNavController().navigate(directions)
    }

    private fun configureAdapter(
        it: SelectCategory
    ) {
        binding.selectExerciseFragmentRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = SelectCategoryAdapter(it.lista)
        binding.selectExerciseFragmentRecyclerView.adapter = adapter

        adapter.onItemClickListener = {
            val directions =
                SelectCategoryFragmentDirections.actionSelectExerciseFragmentToSelectExerciseFragment2(it)
            findNavController().navigate(directions)
        }
    }
}