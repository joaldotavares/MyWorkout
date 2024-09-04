package br.com.myworkout.ui.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.myworkout.R
import br.com.myworkout.commons.extensions.nonNullObserver
import br.com.myworkout.data.Exercise
import br.com.myworkout.databinding.ManageTrainingFragmentBinding
import br.com.myworkout.ui.state.StateAction
import br.com.myworkout.ui.training.viewmodel.TrainingViewModel
import br.com.myworkout.ui.training.viewmodel.TrainingViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import java.util.UUID

class ManageTrainingFragment : Fragment() {

    private lateinit var binding: ManageTrainingFragmentBinding
    private val args by navArgs<ManageTrainingFragmentArgs>()
    private var exercise: Exercise? = null
    private lateinit var saveButton: Button
    private lateinit var name: TextInputEditText
    private lateinit var series: TextInputEditText
    private lateinit var repetitions: TextInputEditText
    private lateinit var load: TextInputEditText
    private lateinit var type: TextInputEditText

    private val viewModel: TrainingViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            TrainingViewModelFactory(requireContext())
        )[TrainingViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            exercise = args.exercise
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ManageTrainingFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveButton = view.findViewById(R.id.edit_training_button)
        name = view.findViewById(R.id.text_input_exercises_name)
        series = view.findViewById(R.id.text_input_exercises_series)
        repetitions = view.findViewById(R.id.text_input_exercises_repetitions)
        load = view.findViewById(R.id.text_input_exercises_load)
        type = view.findViewById(R.id.text_input_exercises_type)

        binding.exercise = this.exercise

        saveButton.setOnClickListener {
            viewModel.manageTraining(
                id = exercise?.id ?: UUID.randomUUID().toString(),
                name = name.text.toString(),
                series = series.text.toString(),
                repetitions = repetitions.text.toString(),
                load = load.text.toString(),
                type = type.text.toString()
            )
            observerState()
            findNavController().popBackStack()
        }


    }

    private fun observerState() {
        viewModel.observerState.nonNullObserver(viewLifecycleOwner) {
            when (it) {
                is StateAction.Update -> Toast.makeText(
                    requireContext(),
                    "Exercicio criado",
                    Toast.LENGTH_LONG
                ).show()

                is StateAction.Insert -> Toast.makeText(
                    requireContext(),
                    "Exercicio editado",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
