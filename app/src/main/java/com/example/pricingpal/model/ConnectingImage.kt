package com.example.pricingpal.model

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.pricingpal.R
import java.io.InputStream

class ConnectingImage() {

    fun loadImages(categories: ArrayList<Category>): List<CategoryImages> {
        val list = ArrayList<CategoryImages>()
        /*
        for(load in im) {
            for (category: Category in categories) {
                //CategoryImages(load, category.category)
                list.add(CategoryImages(im.size, category.category))
            }
        }

         */

        for (category: Category in categories) {
            //CategoryImages(load, category.category)
            list.add(CategoryImages(im.size, category.category))
        }
        /*
        return listOf<CategoryImages>(
            CategoryImages(R.drawable.clothing, category.),
            CategoryImages(R.drawable.jewelry, category.category),
            CategoryImages(R.drawable.appliances, category.category),
            CategoryImages(R.drawable.furniture, category.category),
            CategoryImages(R.drawable.electronics, category.category),
            CategoryImages(R.drawable.toys_and_games, category.category),
            CategoryImages(R.drawable.accessories, category.category),
        )

         */
        return list
    }

    val im = arrayOf(
        R.drawable.clothing,
        R.drawable.jewelry,
        R.drawable.appliances,
        R.drawable.furniture,
        R.drawable.electronics,
        R.drawable.accessories,
        R.drawable.toys_and_games
    )
    /*
    val im = arrayOf(
        R.drawable.clothing,
        R.drawable.jewelry,
        R.drawable.appliances,
        R.drawable.furniture,
        R.drawable.electronics,
        R.drawable.accessories,
        R.drawable.toys_and_games
    )

    val list = ArrayList<CategoryImages>()


    @Composable
    fun ConnectImages(categories1: List<Category>) {
        //val list = ArrayList<CategoryImages>()
        for (load in im) {
            val new = load.toString()
            for (cm in categories1) {
                if (new.equals(cm.category, ignoreCase = true)) {
                    val ic = CategoryImages(load, cm.category)
                    list.add(ic)
                } else {
                    print("Not working")
                }
            }
        }
    }

    fun loadList(): ArrayList<CategoryImages> {
        return arrayListOf()
    }

     */

}
/*
    @Composable
    fun ConnectCategoryImage(categories1: List<Category>, im1: CategoryImages ) {
        val list = ArrayList<CategoryImages>()
        // val imageCategories = CategoryImages(imageName.imagesID,categoryName.category)

        val image = painterResource( im.size /*im1.imagesID*/)
        val image1 = image.toString()

        for (categoryName in categories1) {
            if(image1.equals(categoryName.category, ignoreCase = true)) {
                val imageCategories = CategoryImages(im1.imagesID,categoryName.category)
                list.add(imageCategories)
            }
            else
                print("Not working")
        }
        return list
    }

}

 */