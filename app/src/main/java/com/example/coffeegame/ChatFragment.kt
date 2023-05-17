package com.example.coffeegame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentChatBinding.bind(view)
        currentBarista = Datasource.getCurrentBarista()
        //info update with current barista
        binding.chatNameDisplay.text = currentBarista.name
        binding.characterCustomButton.text = currentBarista.customChatName
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
            binding.textBox2.text = currentBarista.adviceList.random()
        }
        binding.smallTalkButton.setOnClickListener{
            binding.textBox2.text = currentBarista.chatList.random()
        }
        binding.characterCustomButton.setOnClickListener{
            binding.textBox2.text = currentBarista.customList.random()
        }
        binding.flirtButton.setOnClickListener {
            binding.textBox2.text = currentBarista.flirtList.random()
        }
    }
}