package com.tanjil.mywork.ui.Scenes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.hanif.mywork.Remote.getFirebaseData
import com.tanjil.mywork.Data.parseAddresee.Companion.getJson
import kotlinx.coroutines.flow.Flow


@Composable
fun outLineInput() {
    var isDiviActive by remember {
        mutableStateOf(false)
    }
    var divition by remember {
        mutableStateOf(false)
    }

    Box() {

//        OutlinedTextField(
//            value = divition,
//            onValueChange = {
//                divition = it
//            },
//            colors = OutlinedTextFieldDefaults.colors(MaterialTheme.colorScheme.secondary),
//            trailingIcon = {
//                IconButton(onClick = {
//                    valueFromJson = getJson(arrayKEY[0])
//
//                    if (valueFromJson.size > 2) {
//                        isDiviActive = true
//                    }
//                }) {
//                    Icon(
//                        imageVector = Icons.Default.KeyboardArrowDown,
//                        contentDescription = null
//                    )
//                }
//            },
//            readOnly = true,
//
//            )
//
//        if (isDiviActive) {
//            DropdownMenu(
//                expanded = isDiviActive,
//                onDismissRequest = { isDiviActive = false },
//                Modifier.fillMaxWidth(.7f)
//
//            ) {
//                valueFromJson.forEach {
//                    print(it)
//                    DropdownMenuItem(
//                        text = { Text(text = it) },
//                        onClick = {
//                            divition = it
//                            getFirebaseData.userDivision = divition
//                            isDiviActive = false
//                        },
//
//                        )
//                }
//            }
//        }
//
//
    }

}