package com.example.pricingpal.view.editinglist.makelist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.categoryTitle
import com.example.pricingpal.view.repetitivefunctions.pricingPalBar
import com.example.pricingpal.view.repetitivefunctions.searchBar
import com.example.pricingpal.view.repetitivefunctions.settingNavigationBar
import com.example.pricingpal.view.repetitivefunctions.viewItems

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun editItemList(){
    settingNavigationBar()
    LazyColumn(
        modifier = Modifier
            .padding(top = 54.dp)
    ) {
        item {
            pricingPalBar()
        }
        stickyHeader {
            searchBar()
            Divider(thickness = 4.dp, color = Persian_indigo)
        }
        item{
            categoryTitle()
        }
        for(i in 1..10) {
            item {
                viewItems()
            }
        }
    }
}