package com.tanjil.mywork.ui.Scenes

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hanif.mywork.Remote.getFirebaseData.Companion.phoneAuth
import com.tanjil.mywork.Utils.PhoneSignup
import com.tanjil.mywork.Utils.Screen
import kotlinx.coroutines.launch


@Composable
fun sceneSignup(navigation: NavHostController) {

    val context = LocalContext.current
    var activityPass = context as? Activity

    var nameText by remember {
        mutableStateOf("")
    }

    var phoneText by remember {
        mutableStateOf("+880")
    }

    var dialogueText by remember {
        mutableStateOf("+880")
    }
    var isShowDialogue by remember {
        mutableStateOf(false)
    }
    var isShowProgress by remember {
        mutableStateOf(false)
    }


    val scope = rememberCoroutineScope()
    if (activityPass != null) {
        phoneAuth.activity = activityPass
    }



    Column(
        Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        if (isShowProgress){
            CircularProgressIndicator(modifier = Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.size(30.dp))

        Text(
            text = "রেজিস্ট্রেশন করুন",
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )


        Card(
            Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "আপনার তথ্য সুরক্ষিত",
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 5.dp)
            )
            OutlinedTextField(
                value = nameText,
                onValueChange = {
                    nameText = it
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                placeholder = { Text(text = "আপনার নাম লিখুন") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle, contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

                )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = phoneText,
                onValueChange = {
                    phoneText = it
                },
                placeholder = { Text(text = "আপনার নাম্বার লিখুন") },
                leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = null) },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )



            ElevatedButton(
                onClick = {
                    if (phoneText.length < 14) {
                        dialogueText = "+880 যুক্ত করে ১৪ সংখ্যার ফোন নাম্বার নিশ্চিত করুন "
                        isShowDialogue = true

                    } else if (phoneText.length==14) {
                        phoneAuth.phoneNumber = phoneText
                        scope.launch {
                            isShowProgress = true
                            phoneAuth.startPhoneNumberVerification().collect {
                                when (it.isSuccess) {
                                    true -> { navigation.navigate(Screen.otpScene.rout) }

                                    false -> {
                                        dialogueText = it.toString()
                                        isShowDialogue = true
                                    }
                                }
                            }
                        }
                    }

                    if (nameText.length<4){
                        isShowDialogue = true
                        dialogueText = "আপনার নাম লিখুন"
                    }

                },
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(text = "কোড পাঠান ")

            }
            
            if (isShowDialogue){
                isShowDialogue = alartDialogue(content = dialogueText)
            }


        }


    }


}