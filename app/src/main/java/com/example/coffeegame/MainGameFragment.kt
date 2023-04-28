package com.example.coffeegame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.coffeegame.adapter.SustenanceAdapter
import com.example.coffeegame.databinding.FragmentMainGameBinding

class MainGameFragment : Fragment() {
    private val sustenanceViewModel: SustenanceViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //bind main game
        return FragmentMainGameBinding.inflate(inflater, container, false).root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainGameBinding.bind(view)

        val adapter = SustenanceAdapter {
            sustenanceViewModel.updateCurrentSustenance(it)
            view.findNavController().navigate(R.id.ambianceFragment)
            //'it' is whatever current item you clicked
        }
        binding.shoppingSelection.adapter = adapter
        adapter.submitList(sustenanceViewModel.sustenanceData)
        binding.chatButton.setOnClickListener{
            view.findNavController().navigate(R.id.chatFragment)
        }
    }
}