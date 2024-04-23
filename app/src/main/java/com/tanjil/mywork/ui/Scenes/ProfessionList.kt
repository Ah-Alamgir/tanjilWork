package com.tanjil.mywork.ui.Scenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tanjil.mywork.Remote.ProfessionsName


class ProfessionList :ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent{
                uiLogicprof()
            }
    }
}

val proffesion = ProfessionsName.professionsInBangla

@Composable
fun uiLogicprof() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
       ) {
        Text(
            text = "Choose your desire profession",
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth(.8f)
                .align(Alignment.CenterHorizontally)
        )
        LazyHorizontalStaggeredGrid(rows = StaggeredGridCells.Adaptive(minSize = 30.dp)


        ) {
            items(proffesion) { profession ->
                Card(
                    modifier = Modifier
                        .padding(3.dp)
                        .wrapContentHeight()
                        .align(Alignment.CenterHorizontally),

                ) {
                    Text(text = profession, modifier = Modifier.padding(horizontal = 18.dp, vertical = 2.dp))
                }
            }
        }
    }

}


