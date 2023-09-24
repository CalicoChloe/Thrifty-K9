//package com.example.thrifthk9
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.ui.Modifier
//import com.example.thrifthk9.ui.theme.ThrifthK9Theme
//import java.io.BufferedReader
//import java.io.File
//import java.io.FileReader
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            ThrifthK9Theme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    //Greeting("Android")
//                    val reader = ReadCSV()
//                    reader.read()
//                }
//            }
//        }
//    }
//}
//
//
//
//fun readCSV(file: File) {
//    val file = File("testdata.csv")
//    val bufferedReader = BufferedReader(FileReader(file))
//    val items = ArrayList<Item>()
//
//    while(bufferedReader.ready()) {
//        val line = bufferedReader.readLine()
//        val columns =line.split(",")
//        val item = Item(columns[0], columns[1], columns[2].toDouble())
//        items.add(item)
//    }
//}
//
///*
//fun putArrayListIntoListView(arrayList: ArrayList<Any>, listView: ListView) {
//
//    // Create the adapter to convert the array to views
//    val adapter = ArrayAdapter<Any>(this, R.layout.simple_list_item_1, arrayList)
//
//    // Attach the adapter to the ListView
//    listView.setAdapter(adapter)
//}*/
package com.example.thrifthk9
import android.os.Bundle
//import android.widget.ArrayAdapter
//import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
import java.io.InputStream
import java.io.InputStreamReader
import java.util.Scanner

class MainActivity : AppCompatActivity() {

     private val fileName = "testdata.csv"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = readFile()
        for(item in items) {
            println(item)
        }
        // use arrayadapter and define an array
       // val arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf(
//            "Virat Kohli", "Rohit Sharma", "Steve Smith",
//            "Kane Williamson", "Ross Taylor"
//
//        )
       /* val reader = ReadCSV()
        val users = reader.Read()
        // access the listView from xml file
        val mListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter*/
    }

    private fun readFile(): List<Item> {
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




/*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.thrifthk9.ui.theme.ThrifthK9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThrifthK9Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")

                    val reader = ReadCSV()
                    reader.Read()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ShowItems() {
    ThrifthK9Theme {
        Greeting("Android")
        val reader = ReadCSV()
        reader.Read()
    }
}*/
