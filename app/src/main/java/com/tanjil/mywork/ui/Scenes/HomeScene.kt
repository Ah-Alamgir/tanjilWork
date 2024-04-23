package com.tanjil.mywork.ui.Scenes


import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tanjil.mywork.MainActivity
import com.tanjil.mywork.R


@Composable
fun HomeScene() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .height(150.dp)
                    .weight(1f)
                    .padding(end = 4.dp, start = 12.dp)
                    .clickable {
                        context.startActivity(Intent(context, SelectService::class.java))
                    }

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.post_office),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(text = "সেবা গ্রহীতা")
                }
            }



            Card(
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier
                    .height(150.dp)
                    .weight(1f)
                    .padding(end = 12.dp, start = 4.dp)
                    .clickable { context.startActivity(Intent(context, SignupScene::class.java)) }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.motorcycle),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(text = "সেবা দাতা ")
                }
            }

        }
    }
}




