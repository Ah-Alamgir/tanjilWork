package com.tanjil.mywork.ui.Scenes


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hanif.mywork.Remote.getFirebaseData.Companion.phoneAuth
import com.tanjil.mywork.Utils.Screen
import kotlinx.coroutines.launch


@Composable
fun OTPScreen(navigation: NavHostController) {
    val otp = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    var showDialogue by remember {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(.85f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "কোডটি লিখুন",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = TextStyle(fontSize = 20.sp),
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(value = otp.value,
                    onValueChange = { otp.value = it },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    placeholder = { Text(text = "এইখানে লিখুন") })
                Button(
                    onClick = {
                        scope.launch {
                            phoneAuth.signInWithPhoneAuthCredential(otp.value).collect {
                                when (it.isSuccess) {
                                    true -> {
                                        navigation.navigate(Screen.SelecAddress.rout)
                                    }

                                    false -> {
                                        showDialogue = true

                                    }
                                }
                            }
                        }
                    }, modifier = Modifier.fillMaxWidth()
                ) {
                    Text("সাবমিট করুন ")
                }
            }




            if (showDialogue) {
                alartDialogue(content = "কোডটি সঠিক নয়")
            }
        }
    }
}