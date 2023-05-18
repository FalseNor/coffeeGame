package com.example.coffeegame

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import coil.load
import com.example.coffeegame.data.Datasource
import com.example.coffeegame.databinding.FragmentChatBinding
import com.example.coffeegame.model.Barista
class ChatFragment : Fragment() {
    private lateinit var currentBarista: Barista
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //bind chat game
        return FragmentChatBinding.inflate(inflater, container, false).root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentChatBinding.bind(view)
        //this the only because for requiring that api lol
        currentBarista = Datasource.getCurrentBarista()
        //info update with current barista
        binding.chatNameDisplay.setText(currentBarista.name)
        binding.characterCustomButton.setText(currentBarista.customChatName)
        binding.characterImage2.load(currentBarista.imageResourceId)

        //navigation buttons
        binding.backToStartButton.setOnClickListener{
            view.findNavController().navigate(R.id.startFragment)
        }
        binding.backToGameButton.setOnClickListener{
            view.findNavController().navigate(R.id.mainGameFragment)
        }
        //four chat buttons
        binding.adviceButton.setOnClickListener{
            binding.textBox2.setText(currentBarista.adviceList.random())
        }
        binding.smallTalkButton.setOnClickListener{
            binding.textBox2.setText(currentBarista.chatList.random())
        }
        binding.characterCustomButton.setOnClickListener{
            binding.textBox2.setText(currentBarista.customList.random())
        }
        binding.flirtButton.setOnClickListener {
            binding.textBox2.setText(currentBarista.flirtList.random())
        }
    }
}