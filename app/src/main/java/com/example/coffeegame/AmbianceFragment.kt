package com.example.coffeegame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.coffeegame.databinding.FragmentAmbianceBinding

class AmbianceFragment : Fragment() {
    private val sustenanceViewModel: SustenanceViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ambiance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAmbianceBinding.bind(view)
        sustenanceViewModel.currentSustenance.observe(this.viewLifecycleOwner){
            binding.foodImageAmbianceScreen.load(it.imageResourceId)
        }
        binding.textBoxAmbiance.text = getString(R.string.ambient_statement_default)

        //navigation buttons
        binding.ambianceBackToStartButton.setOnClickListener {
            findNavController().navigate(R.id.startFragment)
        }
        binding.ambianceBackToMain.setOnClickListener{
            findNavController().navigate(R.id.mainGameFragment)
        }
    }
}