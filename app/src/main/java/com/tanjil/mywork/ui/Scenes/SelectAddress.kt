package com.tanjil.mywork.ui.Scenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.tanjil.mywork.R
import com.tanjil.mywork.Remote.jsonParser
import org.json.JSONObject
import java.io.File

class SelectAddress : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            pickAddress()
        }
    }
}


@Composable
fun pickAddress() {
    var divition by remember {
        mutableStateOf("আপনার বিভাগ সিলেক্ট করুন")
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    Column(Modifier.fillMaxWidth(1f)) {
        OutlinedTextField(
            value = divition,
            onValueChange = {
                divition = it
            },
            Modifier
                .focusable(enabled = false)
                .clickable { }
                .align(Alignment.CenterHorizontally),
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
                }
            }
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            getAllKeysFromJson("বিভাগ")
        }

    }
}


fun getAllKeysFromJson(key: String) {
    val jsonObject: JsonObject? = JsonParser.parseString(jsonParser.json).asJsonObject
    val district= jsonObject?.getAsJsonArray(key)
    district?.forEach{
        val keys = it.asJsonObject.keySet()
        keys.forEach {
            println(it.toString())
        }
    }

}