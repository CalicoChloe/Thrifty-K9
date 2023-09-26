package com.example.pricingpal.model

import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Item

object FileReaderCSV {

    /**
     * Class: PopulateData
     * @author Connor Murdock
     * @version 1.1
     * @written 2023/09/25
     * Loops through a list of item objects read from the CSV file to create the Category objects and assign the items to their respective categories.
     * @return the ArrayList of Category objects
     */
    fun PopulateData(allItems: ArrayList<Item>): ArrayList<Category> {
        //ArrayList containing every category from the file, empty by default
        val categories = ArrayList<Category>()

        //Keep running until all items have been added
        for(nextItem in allItems) {
            //grab the next item from the arraylist
            val i = nextItem

            //If there are no categories, make one
            if (categories.isEmpty()) {
                val newCategory = Category(i.category, ArrayList())
                newCategory.item.add(i)
                categories.add(newCategory)
            } else {
                var categoryExists = false
                for (c in categories) {
                    //If the category already exists, add that item to the category's arraylist
                    if (c.name == i.category) {
                        c.item.add(i)
                        categoryExists = true
                    }
                }
                //If the category does not exist, create it and then add it to the categories arraylist.
                //Also add the item to the new category
                if (!categoryExists) {
                    val newCategory = Category(i.category, ArrayList())
                    newCategory.item.add(i)
                    categories.add(newCategory)
                }

            }
        }
        //Return the categories arraylist
        //This arraylist contains all of the categories, and each category contains all of its respective items
        return categories
    }
}




