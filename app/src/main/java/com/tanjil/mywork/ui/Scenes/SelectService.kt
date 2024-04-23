package com.tanjil.mywork.ui.Scenes

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tanjil.mywork.Remote.ProfessionsName


class SelectService : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            uiLogic()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable

fun uiLogic() {

    val context = LocalContext.current
    val prof = ProfessionsName.professionsInBangla
    var queryText by remember {
        mutableStateOf(" ")
    }
    var expanded by remember { mutableStateOf(false) }
    var filteredProfessions = prof.filter { it.contains(queryText, ignoreCase = true) }

    val commonProf = listOf(
        "লেখক", "চিত্রকর", "অভিনেত্রী", "দড়াবাজিকর", "মহাকাশযাত্রী",
        "উকিল", "মাঝি",
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Select your desire service",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )

        Spacer(modifier = Modifier.fillMaxHeight(.01f))
        SearchBar(
            query = queryText,
            onQueryChange = {
                queryText = it
            },
            onSearch = {

            },
            active = expanded,
            onActiveChange = { expanded = it },
            modifier = Modifier
                .padding(10.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            trailingIcon = {
                if (expanded) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null,
                        modifier = Modifier.clickable { expanded = false
                            queryText= ""})
                }

            }

        ) {
            filteredProfessions.forEach {
                TextButton(onClick = { queryText = it
                expanded = false}) {
                    Text(text = it)
                }
            }

        }

        ElevatedButton(
            onClick = { context.startActivity(Intent(context, ProfessionList::class.java)) },
            modifier = Modifier.wrapContentWidth(),
            elevation = ButtonDefaults.elevatedButtonElevation(2.dp)
        ) {
            Text(text = "Continue")
        }

        Spacer(modifier = Modifier.height(50.dp))
        LazyHorizontalStaggeredGrid(
            rows = StaggeredGridCells.Adaptive(minSize = 30.dp),
            modifier = Modifier
                .fillMaxWidth(.9f)
                .height(100.dp)
        ) {
            items(commonProf) {
                Card(

                    modifier = Modifier
                        .padding(3.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                        .align(Alignment.CenterHorizontally)
                        .clickable {
                            if (it.contains("More")) {
                                context.startActivity(Intent(context, ProfessionList::class.java))
                            }
                        },


                    ) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 2.dp)
                    )
                }

            }

        }

        Spacer(modifier = Modifier.height(10.dp))


    }
}


