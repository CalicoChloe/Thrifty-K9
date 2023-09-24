package com.example.thrifthk9

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import java.io.InputStream
import java.io.InputStreamReader
import java.util.Scanner

class CSVReader: AppCompatActivity() {


    fun readFile(fileName: String): List<Item> {
        //val fileName = "testdata.csv"
        val inputStream: InputStream = assets.open(fileName)
        val n = Scanner(InputStreamReader(inputStream))

        val itemList = ArrayList<Item>()
        while(n.hasNext()) {
            val line = n.nextLine()
            val row = line.split(",")
            val item = Item(row[0], row[1], row[2].toDouble())
            itemList.add(item)
        }
        n.close()
        return itemList
    }
}