package com.example.coffeegame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeegame.data.Datasource
import com.example.coffeegame.model.Sustenance

class SustenanceViewModel: ViewModel() {
    //setting up all
    private var _currentSustenance: MutableLiveData<Sustenance> = MutableLiveData<Sustenance>()
    val currentSustenance: LiveData<Sustenance>
        get() = _currentSustenance
    private var _sustenanceData: ArrayList<Sustenance> = ArrayList()
    val sustenanceData: ArrayList<Sustenance>
        get() = _sustenanceData

    init {
        //initialize sustenance data
        _sustenanceData = Datasource.getLimitedSustenanceData() //using getLimitedSustenanceData() instead of getSustenanceData()
        _currentSustenance.value = _sustenanceData[0]
    }

    fun updateCurrentSustenance(sustenance: Sustenance) {
        _currentSustenance.value = sustenance
    }

}