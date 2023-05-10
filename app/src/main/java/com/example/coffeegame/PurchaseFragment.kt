package com.example.coffeegame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import coil.load
import com.example.coffeegame.databinding.FragmentPurchaseBinding

class PurchaseFragment : Fragment() {
    private val sustenanceViewModel: SustenanceViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_purchase, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPurchaseBinding.bind(view)

        sustenanceViewModel.currentSustenance.observe(this.viewLifecycleOwner) {
            binding.foodImage.load(it.imageResourceId)
            binding.deathStatementText.text = it.deathStatement
            binding.itemTitleTextView.text = it.name
            binding.itemPriceTextView.text = it.price
            binding.itemDescriptionTextView.text = it.description
            //TODO: use getString(it.deathStatement) when strings are saved properly
            }
            binding.backButtonPurchaseScreen.setOnClickListener{
                view.findNavController().navigate(R.id.mainGameFragment)
            }
            binding.eatButton.setOnClickListener {
                view.findNavController().navigate(R.id.ambianceFragment)
            }
    }

}