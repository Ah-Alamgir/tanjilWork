package com.tanjil.mywork.ui.Scenes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import com.tanjil.mywork.R
import com.tanjil.mywork.Utils.PhoneSignup


class SignupScene : ComponentActivity() {
    val signAuth = PhoneSignup(this)
    var bottomAppbarState = mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            sceneSignup(signAuth)
            signAuth.startPhoneAuth()
            signAuth.isSend.observe(this){
                if (it){
                    bottomAppbarState.value=true
                }
            }
            if (bottomAppbarState.value){
                bottomBar(signAuths = signAuth)
            }
        }



    }
}


@Composable
fun sceneSignup(signAuth: PhoneSignup) {


    var nameText by remember {
        mutableStateOf("")
    }

    var phoneText by remember {
        mutableStateOf("+880")
    }

    var bottomAppbar by remember {
        mutableStateOf(false)
    }



    Column(
        Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
        
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        Image(painter = painterResource(id = R.mipmap.log), contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(
                    CircleShape
                ))

        OutlinedTextField(
            value = nameText,
            onValueChange = {
                nameText = it
            },
            Modifier.fillMaxWidth(.8f),
            placeholder = { Text(text = "আপনার নাম লিখুন") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle, contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

            )

        OutlinedTextField(
            value = phoneText,
            onValueChange = {
                phoneText = it
            },
            placeholder = { Text(text = "আপনার নাম্বার লিখুন") },
            leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = null) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        ElevatedButton(onClick = {
            if (phoneText.length == 14) {
                signAuth.phoneNumber = phoneText
                signAuth.startPhoneNumberVerification()
            }else{
            }
        }) {
            Text(text = "Get Code")

        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottomBar(signAuths:PhoneSignup) {
    var gotcode by remember {
        mutableStateOf("")
    }

    ModalBottomSheet(onDismissRequest = {

    }) {
        OutlinedTextField(
            value = gotcode,
            onValueChange = {
                gotcode = it
            },
            placeholder = { Text(text = "কোডটি লিখুন ") },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextButton(
            onClick = { signAuths.resendVerificationCode() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Resend Code?")
        }
        ElevatedButton(
            onClick = {
                signAuths.verifyPhoneNumberWithCode(gotcode) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Submit Code")
        }
        Spacer(modifier = Modifier.height(80.dp))
    }

}


