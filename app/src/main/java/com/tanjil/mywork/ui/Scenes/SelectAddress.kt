package com.tanjil.mywork.ui.Scenes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hanif.mywork.Remote.getFirebaseData
import com.hanif.mywork.Remote.getFirebaseData.Companion.userDao

import com.hanif.mywork.Remote.getFirebaseData.Companion.userDistrict
import com.hanif.mywork.Remote.getFirebaseData.Companion.userDivision
import com.hanif.mywork.Remote.getFirebaseData.Companion.userPoliceStation
import com.tanjil.mywork.Data.ProfessionsName.Companion.professionsInBangla
import com.tanjil.mywork.Data.parseAddresee.Companion.getJson



@SuppressLint("CoroutineCreationDuringComposition")
@Preview
@Composable
fun SelectAddress() {
    var divition by remember {
        mutableStateOf("আপনার বিভাগ সিলেক্ট করুন")
    }
    var district by remember {
        mutableStateOf("আপনার জেলা সিলেক্ট করুন")
    }
    var policeStation by remember {
        mutableStateOf("আপনার থানা সিলেক্ট করুন")
    }

    var valueFromJson = listOf("")
    var showProfessions by remember {
        mutableStateOf(false)
    }


    val arrayKEY = arrayListOf("বিভাগ")


    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(15.dp)
            
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
                        colors = OutlinedTextFieldDefaults.colors(MaterialTheme.colorScheme.secondary),
                        trailingIcon = {
                            IconButton(onClick = {
                                valueFromJson = getJson(arrayKEY[0])

                                if (valueFromJson.size > 2) {
                                    isDiviActive = true
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null
                                )
                            }
                        },
                        readOnly = true,

                        )

                    if (isDiviActive) {
                        DropdownMenu(
                            expanded = isDiviActive,
                            onDismissRequest = { isDiviActive = false },
                            Modifier.fillMaxWidth(.7f)

                        ) {
                            valueFromJson.forEach {
                                print(it)
                                DropdownMenuItem(
                                    text = { Text(text = it) },
                                    onClick = {
                                        divition = it
                                        userDivision = divition
                                        isDiviActive = false
                                    },

                                    )
                            }
                        }
                    }


                }

                if (!divition.contains("আপনার বিভাগ সিলেক্ট করুন")) {
                    Box {
                        var isDistrictActive by remember {
                            mutableStateOf(false)
                        }

                        OutlinedTextField(value = district, onValueChange = {
                            district = it
                        }, trailingIcon = {
                            IconButton(onClick = {
                                valueFromJson = getJson(arrayKEY[0], divition)
                                arrayKEY.add(divition)
                                if (valueFromJson.size > 2) {
                                    isDistrictActive = true
                                }
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
                                        district = it
                                        userDistrict = district
                                        isDistrictActive = false
                                    },

                                    )
                            }
                        }
                    }

                }



                if (!district.contains("আপনার জেলা সিলেক্ট করুন")) {
                    Box {
                        var ispsActive by remember {
                            mutableStateOf(false)
                        }
                        OutlinedTextField(value = policeStation, onValueChange = {
                            policeStation = it
                        }, trailingIcon = {
                            IconButton(onClick = {
                                valueFromJson = getJson(arrayKEY[0], arrayKEY[1], district)
                                if (valueFromJson.size > 2) {
                                    ispsActive = true
                                }
                            }) {
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
                                        policeStation = it
                                        userPoliceStation = policeStation
                                        ispsActive = false
                                    },
                                )
                            }
                        }

                    }

                }

                if (!policeStation.contains("আপনার থানা সিলেক্ট করুন")) {
                    Button(
                        onClick = {
                            showProfessions = !showProfessions

                        }, Modifier.padding(bottom = 10.dp),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                    )

                    {
                        Text(text = "আপনার পেশাসমূহ নির্বাচন করুন")
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))


            }

        }

        if (showProfessions) {
            showProfession()
        }
    }
}

var selectedProfession = mutableStateListOf("")


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun showProfession() {
    var isselect by remember {
        mutableStateOf(false)
    }

    if (isselect || selectedProfession.size > 0) {
        Column(Modifier.fillMaxWidth(1f), horizontalAlignment = Alignment.CenterHorizontally) {
            Row() {
                selectedProfession.forEach {
                    if (it != "") {
                        Button(onClick = {
                            selectedProfession.remove(it)
                        }, Modifier.padding(start = 10.dp)) {
                            Text(text = it)
                        }
                    }
                }
            }

            if (selectedProfession.size >= 2) {
                Button(
                    onClick = {
                        userDao.profession = selectedProfession
                        getFirebaseData.storeData()

                    },
                    Modifier.fillMaxWidth(.9f)
                ) {
                    Text(text = "Submit")
                }

            }
        }

    }

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(true) }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            LazyColumn {
                items(professionsInBangla) {
                    OutlinedButton(onClick = {
                        if (selectedProfession.size <= 3) {
                            selectedProfession.add(it)
                            professionsInBangla.remove(it)
                            isselect = false
                            isselect = true
                            if (selectedProfession.size >= 4) {
                                showBottomSheet = false
                            }
                        }

                    }, Modifier.padding(start = 15.dp)) {
                        Text(text = it)
                    }
                }
            }
        }
    }

}








