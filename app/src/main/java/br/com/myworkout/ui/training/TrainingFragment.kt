package br.com.myworkout.ui.training

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.myworkout.R
import br.com.myworkout.commons.Constants
import br.com.myworkout.commons.extensions.midnightCalendar
import br.com.myworkout.commons.extensions.nonNullObserver
import br.com.myworkout.commons.extensions.showSnackBar
import br.com.myworkout.data.CalendarData
import br.com.myworkout.data.TrainingData
import br.com.myworkout.databinding.TrainingFragmentBinding
import br.com.myworkout.ui.state.StateError
import br.com.myworkout.ui.state.StateLoading
import br.com.myworkout.ui.state.StateSuccess
import br.com.myworkout.ui.training.adapter.TrainingAdapter
import br.com.myworkout.ui.training.viewmodel.TrainingViewModel
import br.com.myworkout.ui.training.viewmodel.TrainingViewModelFactory
import com.applandeo.materialcalendarview.CalendarView
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import java.util.Calendar


class TrainingFragment : Fragment(), MenuProvider {

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
    private lateinit var groupButton: MaterialButtonToggleGroup
    private lateinit var finishTrainingButton: Button

    private lateinit var calendarView: CalendarView

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        setUpViews(view)

        setUpButtonGroupAction()

        viewModel.trainingViewModel.nonNullObserver(viewLifecycleOwner) {
            when (it) {
                is StateLoading -> setUpLoading()
                is StateSuccess -> it.data?.let { it1 -> setUpSuccess(it1) }
                is StateError -> sendToPageError()
            }
        }

        viewModel.calendarViewModel.nonNullObserver(viewLifecycleOwner) {
            when (it) {
                is StateLoading -> setUpLoading()
                is StateSuccess -> it.data?.let { calendar -> getSelectedDay(calendar) }
                is StateError -> sendToPageError()
            }
        }

        setUpFinishButton()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_items, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.add_exercise_menu_item -> {
                val directions =
                    TrainingFragmentDirections.actionTrainingFragmentToSelectExerciseFragment()
                findNavController().navigate(directions)
                true
            }

            else -> false
        }
    }

    override fun onResume() {
        super.onResume()
        setSelectedButton()
        viewModel.getCalendar()
    }

    private fun setUpFinishButton() {
        finishTrainingButton.setOnClickListener {
            viewModel.finishTraining()
            requireView().requestFocus()
            updateCalendar()
            onResume()
        }
    }

    private fun updateCalendar() {
        val calendar: Calendar = midnightCalendar
        calendar.add(Calendar.DAY_OF_MONTH, Constants.ZERO)
        viewModel.updateCalendar(calendar)
    }


    private fun getSelectedDay(calendar: CalendarData) {
        calendarView.selectedDates = calendar.calendar
    }

    private fun setSelectedButton() {
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
        groupButton = view.findViewById(R.id.table_group_buttons)
        finishTrainingButton = view.findViewById(R.id.training_fragment_finish_button)
        calendarView = view.findViewById(R.id.training_fragment_calendar)
        finishTrainingButton.visibility = GONE
    }

    private fun sendToPageError() {
        binding.fragmentTrainingProgressBar.visibility = GONE
        val directions = TrainingFragmentDirections.actionTrainingFragmentToErrorFragment()
        findNavController().navigate(directions)
    }

    private fun setUpSuccess(data: TrainingData) {
        binding.fragmentTrainingProgressBar.visibility = GONE
        binding.fragmentTrainingRecyclerView.visibility = VISIBLE
        calendarView.visibility = GONE
        setVisibleButton(data)
        configureAdapter(data)
    }

    private fun setVisibleButton(data: TrainingData) {
        if (data.exercises.size < Constants.ONE) {
            finishTrainingButton.visibility = GONE
        } else {
            finishTrainingButton.visibility = VISIBLE
            viewModel.enabledFinishButton.nonNullObserver(viewLifecycleOwner) {
                finishTrainingButton.isEnabled = it
            }
        }
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
                requireContext().showSnackBar(
                    binding.root,
                    R.string.training_fragment_delete_exercise_confirme_snack
                )
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

    private fun setEditClickAdapter() {
        adapter.onItemEditClickListener = { it ->
            val directions =
                TrainingFragmentDirections.actionTrainingFragmentToManageTrainingFragment(it)
            findNavController().navigate(directions)
        }
    }
}
