package com.example.pricingpal
import org.junit.Test
import com.example.pricingpal.model.CSVParser
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Item
import org.junit.Assert

/**
 *
 *
 * @constructor Create empty Csv parser test
 * This test will compare a list of known with a list of categories read
 * in and populated by the CSVParser's function PopulateData
 */
public class CSVParserTest {
    // private variables needed to conduct unit test
    private var testListCategory = ArrayList<Category>()
    private var clothingListItems = ArrayList<Item>()
    private var jewelryListItems = ArrayList<Item>()
    private var fullItemTestList = ArrayList<Item>()

    /**
     * Test getting list of categories
     *
     */
    @Test
   fun testGettingListOfCategories(){
        // series of items added to the clothing item array list to populate test category list
        clothingListItems.add(Item("clothing","shirt",5.00))
        clothingListItems.add(Item("clothing","shoes",8.00))
        clothingListItems.add(Item("clothing","jeans",13.47))
        clothingListItems.add(Item("clothing","jacket",14.00))
        jewelryListItems.add(Item("jewelry","watch",8.00))
        jewelryListItems.add(Item("jewelry","ring",10.00))
        jewelryListItems.add(Item("jewelry","necklace",20.50))

        // add the new categories to the test category list that will be used to
        // compare the category list generated by the PopulateData function
        testListCategory.add(Category("clothing",clothingListItems))
        testListCategory.add(Category("jewelry",jewelryListItems))

        // for loops used to add all items from the clothing and jewelry item list to one
        // full item list
        for((counter, tempItem) in clothingListItems.withIndex()){
            fullItemTestList.add(clothingListItems[counter])
        }
        for((counter, tempItem) in jewelryListItems.withIndex()){
            fullItemTestList.add(jewelryListItems[counter])
        }

        // values used to create the generated category list
        val csvp = CSVParser
        val generatedCategoriesList = csvp.PopulateData(fullItemTestList)

        // console print out of visual comparison of both list
        println(generatedCategoriesList)
        println(testListCategory)

       Assert.assertTrue(compareCategoryList(testListCategory, generatedCategoriesList))
    }

    /**
     * Compare category list
     *
     * @param hardCodedList
     * @param generatedList
     * @return
     * boolean method used to compare the generated category list with the hard coded category list
     */

    fun compareCategoryList(hardCodedList: List<Category>, generatedList: List<Category>): Boolean{
        // boolean used to return if the two list are equal or not
        var categoryListEqualStatus = false;

        // for loop used to compare the category objects found in both list
        for(sub in hardCodedList) {
            // if statement that will change the status of the boolean if list are or are not equal
            if (generatedList == hardCodedList) {
                categoryListEqualStatus = true
            }
        }
        return categoryListEqualStatus
    }

}
