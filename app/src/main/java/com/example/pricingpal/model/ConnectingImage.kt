package com.example.pricingpal.model

import com.example.pricingpal.R

/** I had to manually hard code the images, which the client said was fine,
 * the only problem that I had to type out the categories. Any suggestions to make it better? **/
class ConnectingImage() {
    private val images = ArrayList<CategoryImages>()
    fun loadImages(): List<CategoryImages> {
        images.add(CategoryImages(R.drawable.clothing, "Clothing"))
        images.add(CategoryImages(R.drawable.jewelry, "Jewelry"))
        images.add(CategoryImages(R.drawable.appliances, "Appliances"))
        images.add(CategoryImages(R.drawable.furniture, "Furniture"))
        images.add(CategoryImages(R.drawable.electronics, "electronics"))
        images.add(CategoryImages(R.drawable.toys_and_games, "Toys & Games"))
        images.add(CategoryImages(R.drawable.accessories, "Accessories"))
        return images
    }



    /** Tried to do something like this below, but it would just print out like 4o different times.
     * I left it here if you guys know how to fix it**/
    fun loadImagesTemp(categories: ArrayList<Category>): List<CategoryImages>{
        for(cap: Category in categories){
            load(ca = cap)
        }
        return images
    }

    fun load(ca: Category) {
       // val life = ArrayList<CategoryImages>()
        images.add(CategoryImages(R.drawable.clothing, ca.category ))
        images.add(CategoryImages(R.drawable.jewelry, ca.category))
        images.add(CategoryImages(R.drawable.appliances, ca.category))
        images.add(CategoryImages(R.drawable.furniture, ca.category))
        images.add(CategoryImages(R.drawable.electronics, ca.category))
        images.add(CategoryImages(R.drawable.toys_and_games, ca.category))
        images.add(CategoryImages(R.drawable.accessories, ca.category))

    }

}
