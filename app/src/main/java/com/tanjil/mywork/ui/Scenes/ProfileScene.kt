package com.tanjil.mywork.ui.Scenes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tanjil.mywork.R
import com.tanjil.mywork.Remote.UserDAO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun ShowProfile() {
    val myInfo = UserDAO()
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Spacer(modifier = Modifier.fillMaxHeight(.02f))
        Image(
            painter = painterResource(id = if (myInfo.ismale) R.mipmap.happy else R.mipmap.girl),
            contentDescription = null,
            Modifier
                .border(5.dp, color = Color.Black, CircleShape)
                .clip(CircleShape)
        )
        Text(text = myInfo.name,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = myInfo.phoneNumber,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = MaterialTheme.colorScheme.tertiary
        )
        InputChip(
            selected = if (myInfo.ismale) true else false,
            onClick = { /*TODO*/ },
            label = { Text(text = if (myInfo.ismale) "পুরুষ" else "নারী") })

        Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            myInfo.profession.forEach {
                Card {
                    Text(text = it, modifier = Modifier.padding(10.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        
        Button(onClick = { /*TODO*/ }, Modifier.fillMaxWidth(.8f)) {
            Text(text = "এডিট করুন ")
        }

    }
}