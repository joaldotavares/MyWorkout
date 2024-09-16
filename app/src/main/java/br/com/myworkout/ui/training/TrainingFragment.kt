package br.com.myworkout.ui.training

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.myworkout.R
import br.com.myworkout.commons.extensions.nonNullObserver
import br.com.myworkout.data.TrainingData
import br.com.myworkout.databinding.TrainingFragmentBinding
import br.com.myworkout.ui.state.StateError
import br.com.myworkout.ui.state.StateLoading
import br.com.myworkout.ui.state.StateSuccess
import br.com.myworkout.ui.training.viewmodel.TrainingViewModel
import br.com.myworkout.ui.training.viewmodel.TrainingViewModelFactory
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

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
    private lateinit var groupButton: MaterialButtonToggleGroup

    private lateinit var binding: TrainingFragmentBinding

    private lateinit var adapter: TrainingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TrainingFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        when (groupButton.checkedButtonId) {
            firstButtonGroup.id -> {
                getSpecify(firstButtonGroup.text.toString())
            }
            secondButtonGroup.id -> {
                getSpecify(secondButtonGroup.text.toString())
            }
            thirdButtonGroup.id -> {
                getSpecify(thirdButtonGroup.text.toString())
            }
            fourthButtonGroup.id -> {
                getSpecify(fourthButtonGroup.text.toString())
            }
        }
    }

    private fun getSpecify(type: String) {
        viewModel.getSpecifyTraining(type)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews(view)

        setUpButtonGroupAction()

        viewModel.trainingViewModel.nonNullObserver(viewLifecycleOwner) {
            when (it) {
                is StateLoading -> setUpLoading()
                is StateSuccess -> it.data?.let { it1 -> setUpSuccess(it1) }
                is StateError -> sendToPageError()
            }
        }
    }

    private fun setUpButtonGroupAction() {
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
    }

    private fun setUpViews(view: View) {
        firstButtonGroup = view.findViewById(R.id.button_table_group_first)
        secondButtonGroup = view.findViewById(R.id.button_table_group_second)
        thirdButtonGroup = view.findViewById(R.id.button_table_group_third)
        fourthButtonGroup = view.findViewById(R.id.button_table_group_fourth)
        addButtonGroup = view.findViewById(R.id.button_table_group_add)
        groupButton = view.findViewById(R.id.table_group_buttons)
    }

    private fun sendToPageError() {
        binding.fragmentTrainingProgressBar.visibility = GONE
        val directions = TrainingFragmentDirections.actionTrainingFragmentToErrorFragment()
        findNavController().navigate(directions)
    }

    private fun setUpSuccess(data: TrainingData) {
        binding.fragmentTrainingProgressBar.visibility = GONE
        binding.fragmentTrainingRecyclerView.visibility = VISIBLE
        Log.i("ID SELECIONADO", "${groupButton.checkedButtonId}")
        Log.i("ID PRIMEIRO","${firstButtonGroup.id}")
        Log.i("ID SEGUNDO","${secondButtonGroup.id}")
        Log.i("ID TERCEIRO","${thirdButtonGroup.id}")
        Log.i("ID QUARTO","${fourthButtonGroup.id}")

        configureAdapter(data)
    }

    private fun setUpLoading() {
        binding.fragmentTrainingProgressBar.visibility = VISIBLE
        binding.fragmentTrainingRecyclerView.visibility = GONE
    }

    private fun configureAdapter(
        it: TrainingData
    ) {
        binding.fragmentTrainingRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = TrainingAdapter(it.exercises, viewModel)
        binding.fragmentTrainingRecyclerView.adapter = adapter

        setUpSwipeToDeleteExercise()
        setEditClickAdapter()
        setAddButton()
        setExerciseItemClicked()
    }

    private fun setUpSwipeToDeleteExercise() {
        val swipeHandler = object : SwipeToDeleteCallback() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                setUpDialogDeleteExercise(viewHolder)
                requireView().requestFocus()
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(binding.fragmentTrainingRecyclerView)
    }

    private fun setUpDialogDeleteExercise(viewHolder: RecyclerView.ViewHolder) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(requireContext().getString(R.string.training_fragment_delete_exercise_message))
            .setPositiveButton(requireActivity().getString(R.string.training_fragment_delete_exercise_confirm)) { _, _ ->
                adapter.removeExerciseOnPosition(viewHolder.bindingAdapterPosition)
            }
            .setNegativeButton(requireActivity().getString(R.string.training_fragment_delete_exercise_cancel)) { _, _ ->
                adapter.notifyItemChanged(viewHolder.bindingAdapterPosition)
            }
            .create()
            .show()
    }

    private fun setExerciseItemClicked() {
        adapter.onItemClickListener = { it ->
            val directions =
                TrainingFragmentDirections.actionTrainingFragmentToDetailsExerciseFragment(it)
            findNavController().navigate(directions)
        }
    }

    private fun setAddButton() {
        addButtonGroup.setOnClickListener {
            val directions =
                TrainingFragmentDirections.actionTrainingFragmentToManageTrainingFragment(null)
            findNavController().navigate(directions)
        }
    }

    private fun setEditClickAdapter() {
        adapter.onItemEditClickListener = { it ->
            val directions =
                TrainingFragmentDirections.actionTrainingFragmentToManageTrainingFragment(it)
            findNavController().navigate(directions)
        }
    }
}
