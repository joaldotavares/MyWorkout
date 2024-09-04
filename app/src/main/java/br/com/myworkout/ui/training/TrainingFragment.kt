package br.com.myworkout.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.myworkout.R
import br.com.myworkout.commons.extensions.nonNullObserver
import br.com.myworkout.data.TrainingData
import br.com.myworkout.databinding.TrainingFragmentBinding
import br.com.myworkout.ui.state.StateLoading
import br.com.myworkout.ui.state.StateSuccess
import br.com.myworkout.ui.training.viewmodel.TrainingViewModel
import br.com.myworkout.ui.training.viewmodel.TrainingViewModelFactory
import com.google.android.material.button.MaterialButton

class TrainingFragment : Fragment() {

    private val viewModel: TrainingViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            TrainingViewModelFactory(requireContext())
        )[TrainingViewModel::class.java]
    }

    private lateinit var firstButtonGroup: MaterialButton

    private lateinit var secondButtonGroup: MaterialButton

    private lateinit var thirdButtonGroup: MaterialButton

    private lateinit var fourthButtonGroup: MaterialButton

    private lateinit var addButtonGroup: MaterialButton


    private lateinit var binding: TrainingFragmentBinding
    private lateinit var adapter: TrainingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TrainingFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getSpecifyTraining(firstButtonGroup.text.toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstButtonGroup = view.findViewById(R.id.button_table_group_first)
        secondButtonGroup = view.findViewById(R.id.button_table_group_second)
        thirdButtonGroup = view.findViewById(R.id.button_table_group_third)
        fourthButtonGroup = view.findViewById(R.id.button_table_group_fourth)
        addButtonGroup = view.findViewById(R.id.button_table_group_add)

        firstButtonGroup.setOnClickListener {
            viewModel.getSpecifyTraining(firstButtonGroup.text.toString())
        }
        secondButtonGroup.setOnClickListener {
            viewModel.getSpecifyTraining(secondButtonGroup.text.toString())
        }
        thirdButtonGroup.setOnClickListener {
            viewModel.getSpecifyTraining(thirdButtonGroup.text.toString())
        }
        fourthButtonGroup.setOnClickListener {
            viewModel.getSpecifyTraining(fourthButtonGroup.text.toString())
        }
        addButtonGroup.isChecked = false

        viewModel.trainingViewModel.nonNullObserver(viewLifecycleOwner) {
            when (it) {
                is StateLoading -> setUpLoading()
                is StateSuccess -> it.data?.let { it1 -> setUpSuccess(it1) }
                else -> {}
            }
        }
    }

    private fun setUpSuccess(data: TrainingData) {
        configureAdapter(data)
    }

    private fun setUpLoading() {
        TODO("Not yet implemented")
    }

    private fun configureAdapter(
        it: TrainingData
    ) {
        adapter = TrainingAdapter(it)
        binding.fragmentTrainingRecyclerView.adapter = adapter
        binding.fragmentTrainingRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter.onItemEditClickListener = { it ->
            val directions =
                TrainingFragmentDirections.actionTrainingFragmentToManageTrainingFragment(it)
            findNavController().navigate(directions)
        }

        addButtonGroup.setOnClickListener {
            val directions = TrainingFragmentDirections.actionTrainingFragmentToManageTrainingFragment(null)
            findNavController().navigate(directions)
        }

        adapter.onItemClickListener = { it ->
            val directions =
                TrainingFragmentDirections.actionTrainingFragmentToDetailsExerciseFragment(it)
            findNavController().navigate(directions)
        }
    }
}