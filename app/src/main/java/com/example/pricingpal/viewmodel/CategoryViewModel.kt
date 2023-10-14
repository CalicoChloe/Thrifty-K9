package com.example.pricingpal.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.pricingpal.model.CSVParser
import com.example.pricingpal.model.CSVReader

class CategoryViewModel(context: Context): ViewModel() {
    val csvp = CSVParser
    val categories = csvp.PopulateData(CSVReader.readFile(context, "testdata.csv"))
}