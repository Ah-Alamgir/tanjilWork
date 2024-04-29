package com.tanjil.mywork.ui.Scenes


import androidx.compose.animation.core.EaseInCirc
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.tanjil.mywork.R
import com.tanjil.mywork.Utils.Screen

@Composable
fun HomeScene(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        Spacer(modifier = Modifier.fillMaxHeight(.1f))
        Box(modifier = Modifier.fillMaxWidth(.5f)) {
            Image(
                painter = painterResource(id = R.mipmap.log),
                contentDescription = null,
                modifier = Modifier.clip(CircleShape)
            )
        }


        Text(
            text = "আপনার কাজের ঠিকানা",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.titleMedium.fontSize
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .height(150.dp)
                    .weight(1f)
                    .padding(end = 10.dp, start = 12.dp)
                    .clickable {
                        navHostController.navigate(Screen.SelectService.rout)
                    },
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)

            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .fillMaxSize(1f)
                        .background(color = Color.White)

                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.post_office),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxSize(.5f)
                    )
                    Text(
                        text = "সেবা গ্রহীতা",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = MaterialTheme.typography.titleLarge.fontSize
                    )
                }
            }



            Card(
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .height(150.dp)
                    .weight(1f)
                    .padding(end = 12.dp, start = 4.dp)
                    .clickable {
                        val user = Firebase.auth.currentUser?.phoneNumber
                        if (user != null) {
                            navHostController.navigate(Screen.ProfileScene.rout)
                        } else {
                            navHostController.navigate(Screen.SIgnUp.rout)
                        }

                    },
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)

            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .fillMaxSize(1f)
                        .background(color = Color.White)
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.motorcycle),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxSize(.5f)
                    )
                    Text(
                        text = "সেবা দাতা",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = MaterialTheme.typography.titleLarge.fontSize
                    )
                }
            }

        }
    }


}




