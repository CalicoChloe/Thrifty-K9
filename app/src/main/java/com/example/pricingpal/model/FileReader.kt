package com.example.composelearning

import java.io.File

//THE FOLLOWING CLASS IS PSEUDOCODE
//Connor Murdock
class FileReader {
    /*
    * Step 1:
    * Grab the file from the device
    * Read the file and turn each line into an Item. Add to a temp arraylist
    */

    /*
    * Step 2:
    * Loop through the temp Item arraylist, and create new categories
    * Add items to the category arraylists
    */

    fun GrabFileFromDevice(filePath: String) {
        try {
            //find file by filepath
        } catch (e: Exception) {
            //display error if file can't be found
        }
        //return File
    }

    //Items have a category, a name, and a price
    class Item(
        val category: String,
        val name: String,
        val price: Double
    )

    //Categories have a name and an arraylist that holds all of the items that belong to that category
    class Category (
        val name: String,
        val items: ArrayList<Item>
        //create an empty item array list when a category object is created
    )

    fun PopulateData(file: File) {
        //csv reader will break data down by line
        //for this pseudocode, we will assume "line" is the next line of the file, broken into an array of Strings
        val line = arrayOf("category","name","price")
        //ArrayList containing every category from the file
        val categories = ArrayList<Category>()

        //Keep running until the end of the file is reached
        while(true) {
            //create an item from the line of data
            val i = Item(line[0], line[1], line[2].toDouble())

            for (c in categories) {
                //If the category already exists, add that item to the category's arraylist
                if (c.name == i.category) {
                    c.items.add(i)
                }
                //If the category does not exist, create it and then add it to the categories arraylist.
                //Also add the item to the new category
                else {
                    val newCategory = Category(line[0], ArrayList<Item>())
                    newCategory.items.add(i)
                    categories.add(newCategory)
                }
            }
        }
        //Return the categories arraylist at the end
        //This arraylist contains all of the categories, and each category contains all of its respective items
    }
}