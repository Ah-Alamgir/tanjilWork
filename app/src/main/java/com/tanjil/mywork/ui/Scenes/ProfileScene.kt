package com.tanjil.mywork.ui.Scenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tanjil.mywork.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ProfileScene : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountrySelectionInput()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun CountrySelectionInput() {
    Column(modifier = Modifier.padding(10.dp)) {

        var expanded by remember { mutableStateOf(false) }
        var inputText by remember { mutableStateOf("") }
        val mCities =
            listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

        SearchBar(
            query = inputText,
            onQueryChange = { inputText = it },
            onSearch = {
            },
            active = expanded,
            onActiveChange = { expanded = it },
            placeholder = { Text(text = "Select your Divition") },
            ) {
            for (i in 0..5){
                var it = mCities[i]
                Text(
                    text = it, modifier = Modifier
                        .padding(10.dp,5.dp,0.dp,5.dp)
                        .fillMaxWidth(1f)
                        .clickable {
                            inputText =it
                            GlobalScope.launch {
                                delay(800) // Delay for 1 second
                                expanded = false
                            }
                        },
                    fontSize = MaterialTheme.typography.titleMedium.fontSize

                )
            }


        }


        Spacer(modifier = Modifier.padding(horizontal = 10.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(.8f)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Search")
        }
    }
}

