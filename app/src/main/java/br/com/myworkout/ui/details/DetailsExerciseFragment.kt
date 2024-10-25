package br.com.myworkout.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import br.com.myworkout.R
import br.com.myworkout.data.Exercise
import br.com.myworkout.databinding.DetailsExerciseFragmentBinding
import com.bumptech.glide.Glide

class DetailsExerciseFragment : Fragment() {

    private val args by navArgs<DetailsExerciseFragmentArgs>()
    private lateinit var exercise: Exercise
    private lateinit var binding: DetailsExerciseFragmentBinding
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            exercise = args.exerciseDetail
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.exercise = exercise
        image = view.findViewById(R.id.details_training_image)
        Glide.with(requireContext()).load(exercise.image).into(image)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsExerciseFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
}
