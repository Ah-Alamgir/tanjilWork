package com.tanjil.mywork.ui.Scenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.tanjil.mywork.R
import com.tanjil.mywork.Remote.ProfessionsName
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

@Preview
@Composable
fun pickAddress() {
    var divition by remember {
        mutableStateOf("আপনার বিভাগ সিলেক্ট করুন")
    }
    var district by remember {
        mutableStateOf("আপনার জেলা সিলেক্ট করুন")
    }
    var policeStation by remember {
        mutableStateOf("আপনার থানা সিলেক্ট করুন")
    }

    var valueFromJson = arrayListOf("")
    var gotListof= arrayListOf("বিভাগ")





    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxWidth(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "আপনার ঠিকানা নির্বাচন করুন",
                Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.CenterHorizontally),
                fontSize = MaterialTheme.typography.titleMedium.fontSize
            )

            Box() {
                var isDiviActive by remember {
                    mutableStateOf(false)
                }

                OutlinedTextField(
                    value = divition,
                    onValueChange = {
                        divition = it
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            getJson("বিভাগ")
//                            if (valueFromJson.size > 2) {
//                                isDiviActive = true
//                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                    },
                    readOnly = true,

                    )

                DropdownMenu(
                    expanded = isDiviActive, onDismissRequest = { isDiviActive = false },
                    Modifier.fillMaxWidth(.7f)

                    ) {
                    valueFromJson.forEach {
                        DropdownMenuItem(
                            text = { Text(text = it) },
                            onClick = {
                                divition = it
                                gotListof.add(divition)
                                isDiviActive = false
                            },

                            )
                    }
                }

            }


            Box {
                var isDistrictActive by remember {
                    mutableStateOf(false)
                }

                OutlinedTextField(value = district, onValueChange = {
                    district = it
                }, trailingIcon = {
                    IconButton(onClick = {
                        valueFromJson = getValuesFromJson(gotListof)
                        isDistrictActive = true
                    }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                }, readOnly = true

                )

                DropdownMenu(
                    expanded = isDistrictActive,
                    onDismissRequest = { isDistrictActive = false },
                    modifier = Modifier.fillMaxWidth(.7f)
                ) {
                    valueFromJson?.forEach {
                        DropdownMenuItem(
                            text = { Text(text = it) },
                            onClick = {
                                divition = it
                                isDistrictActive = false
                            },

                            )
                    }
                }
            }


            Box {
                var ispsActive by remember {
                    mutableStateOf(false)
                }
                OutlinedTextField(value = policeStation, onValueChange = {
                    policeStation = it
                }, trailingIcon = {
                    IconButton(onClick = { ispsActive = true }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                }, readOnly = true

                )

                DropdownMenu(
                    expanded = ispsActive,
                    onDismissRequest = { ispsActive = false },
                    modifier = Modifier.fillMaxWidth(.8f)
                ) {
                    valueFromJson.forEach {
                        DropdownMenuItem(
                            text = { Text(text = it) },
                            onClick = {
                                divition = it
                                ispsActive = false
                            },

                            )
                    }
                }

            }


            Text(text = "আপনার পেশাসমূহ নির্বাচন করুন")

            LazyHorizontalStaggeredGrid(
                rows = StaggeredGridCells.Adaptive(minSize = 28.dp),
                Modifier
                    .fillMaxWidth(1f)
                    .padding(20.dp)
            ) {
                items(ProfessionsName.professionsInBangla) {
                    Text(
                        text = "    $it    ",
                        Modifier
                            .padding(5.dp)
                            .background(Color.Cyan, shape = CircleShape)
                    )
                }
            }
        }
    }

}


fun getValuesFromJson(keys: List<String>): ArrayList<String> {
    var jsonObject: JsonObject? = JsonParser.parseString(jsonParser.json).asJsonObject
    val values = arrayListOf<String>()
    for (key in keys) {
        jsonObject = jsonObject?.getAsJsonObject(key)
    }
    jsonObject?.keySet()?.forEach {
        values.add(it.toString())
    }
    println(jsonObject?.keySet())
    return values
}

fun getJson(key:String){
    val gsonOBJECT:JsonObject? = JsonParser.parseString(jsonParser.json).asJsonObject
//    val fullJson = gsonOBJECT?.getAsJsonArray(key)?.forEach {
//        it.asJsonObject.getAsJsonArray("চট্টগ্রাম").forEach {
//            it?.asJsonObject?.getAsJsonArray("কুমিল্লা")?.forEach {
//                println(it)
//            }
//        }

        println(gsonOBJECT?.getAsJsonArray(key))
//        println(gsonOBJECT.getAsJsonArray(key).)
//        println(it.asJsonObject.keySet())
//        println()

    }




