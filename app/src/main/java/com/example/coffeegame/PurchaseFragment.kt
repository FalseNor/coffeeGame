package com.example.coffeegame

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import coil.load
import com.example.coffeegame.data.Datasource
import com.example.coffeegame.databinding.FragmentPurchaseBinding
import com.example.coffeegame.model.Barista


class PurchaseFragment : Fragment() {
    private val sustenanceViewModel: SustenanceViewModel by activityViewModels()
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var currentBarista: Barista
    private val myPreference: String = "mypref"
    private val name: String = "nameKey"
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
        currentBarista = Datasource.getCurrentBarista()
        //update view with current barista data
        binding.purchaseScreenCharacterImage.load(currentBarista.imageResourceId)
        binding.baristaNameView.text = currentBarista.name

        //init shared preferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context)

        sustenanceViewModel.currentSustenance.observe(this.viewLifecycleOwner) {
            binding.foodImage.load(it.imageResourceId)
            binding.deathStatementText.text = it.deathStatement
            binding.itemTitleTextView.text = it.name
            binding.itemPriceTextView.text = it.price
            binding.itemDescriptionTextView.text = it.description
            //TODO: use getString(it.deathStatement) when strings are saved properly
            }
        //navigation buttons
        binding.backButtonPurchaseScreen.setOnClickListener{
            view.findNavController().navigate(R.id.mainGameFragment)
        }
        binding.purchaseScreenBackToStartButton.setOnClickListener {
            view.findNavController().navigate(R.id.startFragment)
        }
        binding.eatButton.setOnClickListener {
            view.findNavController().navigate(R.id.ambianceFragment)
            save(view, binding)
        }

        //if there already is a saved name value, update the edit textview thingy with it
        if (sharedPreferences.contains(name)) {
            binding.orderNameInput.setText(sharedPreferences.getString(name, ""))
        }
    }
    private fun save(view: View?, binding: FragmentPurchaseBinding) {
        val n = binding.orderNameInput.text.toString()
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(name, n)
        editor.apply()
        Log.i("NAME","new name stored of value $n")
    }

}