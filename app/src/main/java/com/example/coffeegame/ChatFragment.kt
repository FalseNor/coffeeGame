package com.example.coffeegame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.coffeegame.databinding.FragmentChatBinding

// TODO: Rename parameter arguments, choose names that match
class ChatFragment : Fragment() {
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

        binding.backButton2.setOnClickListener{
            view.findNavController().navigate(R.id.mainGameFragment)
        }
    }
}