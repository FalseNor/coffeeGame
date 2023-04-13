package com.example.coffeegame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coffeegame.adapter.SustenanceAdapter
import com.example.coffeegame.databinding.FragmentMainGameBinding

class MainGameFragment : Fragment() {
    private lateinit var binding: FragmentMainGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainGameBinding.inflate(layoutInflater)

        binding.shoppingSelection.adapter = SustenanceAdapter()
        binding.shoppingSelection.setHasFixedSize(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}