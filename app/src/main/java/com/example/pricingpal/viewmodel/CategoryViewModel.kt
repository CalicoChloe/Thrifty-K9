package com.example.pricingpal.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.pricingpal.model.CSVParser
import com.example.pricingpal.model.CSVReader

/**
 * ViewModel class to hold the data read from the csv file
 *
 * This class uses the CSVParser and CSVReader classes to read and parse data from testdata.csv
 *
 * @property context the required context to enable file access (usually from MainActivity.kt)
 *
 * @author Connor Murdock
 */
class CategoryViewModel(context: Context): ViewModel() {
    val csvp = CSVParser
    val categories = csvp.PopulateData(CSVReader.readFile(context, "testdata.csv"))
}