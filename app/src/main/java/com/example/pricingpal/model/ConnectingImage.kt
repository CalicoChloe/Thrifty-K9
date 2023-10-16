package com.example.pricingpal.model

import com.example.pricingpal.R

class ConnectingImage() {
    val list = ArrayList<CategoryImages>()
    val listTemp = ArrayList<CategoryImages>()
    private fun temp(categories: ArrayList<Category>): List<CategoryImages>{
        //val list = ArrayList<CategoryImages>()
        /*
        for (category: Category in categories) {
            list.add(CategoryImages(images.size, category.category))
        }

         */

        /*
        val temp = "Temp string"
        for(load in images) {
            list.add(CategoryImages(load, "Temp"))
        }

         */


            outer_loop@  for (category: Category in categories) {
                for(load in images) {
                    list.add(CategoryImages(load, category.category))
                   // categories.clear()
                }
            if(list.size == 7){
                break@outer_loop
            }
        }


        /*
        for(l in images){
            for(o in images) {
                val oe = o
                for (category: Category in categories) {
                    if (images[0] != images[1]) {
                        list.add(CategoryImages(l, "Temp"))
                    }
                    else {
                        list.add(CategoryImages(l, category.category))
                    }
                }
            }
        }

         */
        return list

    }

    fun loadImages(categories: ArrayList<Category>): List<CategoryImages> {
        temp(categories)
        val life = ArrayList<CategoryImages>()
        life.add(CategoryImages(R.drawable.clothing, "Clothing"))
        life.add(CategoryImages(R.drawable.jewelry, "Jewelry"))
        life.add(CategoryImages(R.drawable.appliances, "Appliances"))
        life.add(CategoryImages(R.drawable.furniture, "Furniture"))
        life.add(CategoryImages(R.drawable.electronics, "electronics"))
        life.add(CategoryImages(R.drawable.toys_and_games, "Toys & Games"))
        life.add(CategoryImages(R.drawable.accessories, "Accessories"))


        /*
        outer_loop@ for(ca: CategoryImages in list){
            for(c: Category in categories){
                if(ca.category != c.category){
                    listTemp.add(CategoryImages(ca.imagesID, c.category))
                }
            }
            if(list.size == 8){
                break@outer_loop
            }
        }
        return listTemp

         */
        return life
    }


     val images = arrayOf(
        R.drawable.clothing,
        R.drawable.jewelry,
        R.drawable.appliances,
        R.drawable.furniture,
        R.drawable.electronics,
        R.drawable.accessories,
        R.drawable.toys_and_games
    )
}
