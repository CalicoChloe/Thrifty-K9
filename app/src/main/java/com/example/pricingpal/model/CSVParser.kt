package com.example.pricingpal.model

object CSVParser {

    /**
     * Function to create a HashMap of Category Items from a List of Item objects
     *
     * This class defines the item class and its properties.
     *
     * @property allItems the list of Items read in by the readFile() function
     *
     * @return The final HashMap of Category objects, using the Category name as the key and the respective Category object as the value
     *
     * @author Connor Murdock
     */
    fun PopulateData(allItems: List<Item>): HashMap<String, Category> {
        //ArrayList containing every category from the file, empty by default
        val categories = HashMap<String, Category>()

        //Keep running until all items have been added
        for(nextItem in allItems) {
            //grab the next item from the list
            val i = nextItem

            //If there are no categories, make one
            if (categories.isEmpty()) {
                val newCategory = Category(i.category, ArrayList())
                newCategory.item.add(i)
                categories.put(newCategory.category, newCategory)
            } else {
                var categoryExists = false
                for (c in categories) {
                    //If the category already exists, add that item to the category's arraylist
                    if (c.key == i.category) {
                        c.value.item.add(i)
                        categoryExists = true
                    }
                }
                //If the category does not exist, create it and then add it to the categories arraylist.
                //Also add the item to the new category
                if (!categoryExists) {
                    val newCategory = Category(i.category, ArrayList())
                    newCategory.item.add(i)
                    categories.put(newCategory.category, newCategory)
                }

            }
        }
        //Return the categories arraylist
        //This arraylist contains all of the categories, and each category contains all of its respective items
        return categories
    }
}




