package com.example.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListCard()
        }
    }
}

@Composable
fun ListCard() {
    val list = List(40) { "Item $it" }
    LazyColumn() {
        items(list) {
            Card(text = it)
        }
    }

}

@Composable
fun Card(modifier: Modifier = Modifier, text: String) {

    var isClicked by remember {
        mutableStateOf(false)
    }

    val bgColor by animateColorAsState(
        if (isClicked) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.secondary
        }
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(4.dp)
            .background(bgColor)
            .clickable {
                isClicked = !isClicked
            }
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape),
            imageVector = Icons.Default.Home, contentDescription = "Home"
        )
        Spacer(modifier = Modifier.width(4.dp))
        SayHello(text = text)

    }

}


@Composable
fun SayHello(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier.padding(4.dp),
        textAlign = TextAlign.Justify,
        color = MaterialTheme.colorScheme.primary,
        maxLines = 5,
        text = text
    )
}

@Composable
@Preview
fun preview() {
    ListCard()
}




