package com.tanjil.mywork.ui.Scenes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hanif.mywork.Remote.getFirebaseData.Companion.getData
import com.hanif.mywork.Remote.getFirebaseData.Companion.userDao
import com.tanjil.mywork.R

@Preview
@Composable
fun searchResult() {
    val profiles = getData("")
    LazyColumn(contentPadding = PaddingValues(10.dp)) {
        items(profiles) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    painter = painterResource(id = if (it.ismale)R.mipmap.happy else R.mipmap.girl),
                    contentDescription = null,
                    modifier = Modifier.clip(CircleShape).size(50.dp)
                )
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = it.name, Modifier.padding(start = 6.dp))
                    Row {
                        it.profession.forEach { profession ->
                            Card(Modifier.padding(3.dp)) {
                                Text(text = profession, Modifier.padding(5.dp))
                            }
                        }
                    }
                }

                Image(
                    imageVector = Icons.Filled.Call,
                    contentDescription = null,
                    Modifier.clickable {

                    }.align(Alignment.CenterVertically))
            }
        }

    }
}