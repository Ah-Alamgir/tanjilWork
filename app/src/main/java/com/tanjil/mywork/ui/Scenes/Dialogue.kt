package com.tanjil.mywork.ui.Scenes

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun alartDialogue(content: String):Boolean{
    val openAlertDialog = remember { mutableStateOf(true) }
    when {
        openAlertDialog.value -> {
            AlertDialog(onDismissRequest = { openAlertDialog.value = false }, confirmButton = {
                TextButton(onClick = { openAlertDialog.value = false
                }) {
                    Text(text = "ঠিক আছে")
                }
            },
                text = { Text(text = content)}
            )
        }
    }
    return openAlertDialog.value
}
