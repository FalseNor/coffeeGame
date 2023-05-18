package com.example.coffeegame

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import coil.load
import com.example.coffeegame.adapter.SustenanceAdapter
import com.example.coffeegame.data.Datasource
import com.example.coffeegame.databinding.FragmentMainGameBinding
import com.example.coffeegame.model.Barista

class MainGameFragment : Fragment() {
    private val sustenanceViewModel: SustenanceViewModel by activityViewModels()
    private lateinit var currentBarista: Barista
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //bind main game
        return FragmentMainGameBinding.inflate(inflater, container, false).root
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainGameBinding.bind(view)
        Log.i("TIME", Datasource.getLocalTime().toString())

        currentBarista = Datasource.getCurrentBarista()
        //update view with current barista info
        binding.nameDisplay.setText(currentBarista.name)
        binding.characterImage.load(currentBarista.imageResourceId)
        binding.textBox.setText(currentBarista.normalGreetingStatement)

        val adapter = SustenanceAdapter {
            sustenanceViewModel.updateCurrentSustenance(it)
            view.findNavController().navigate(R.id.purchaseFragment)
            //'it' is whatever current item you clicked
            //also navigates on click
        }
        binding.shoppingSelection.adapter = adapter
        adapter.submitList(sustenanceViewModel.sustenanceData)

        //nav buttons
        binding.chatButton.setOnClickListener{
            view.findNavController().navigate(R.id.chatFragment)
        }
        binding.backButton.setOnClickListener{
            view.findNavController().navigate(R.id.startFragment)
        }
    }
}