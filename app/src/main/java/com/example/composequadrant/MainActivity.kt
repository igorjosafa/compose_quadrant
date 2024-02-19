package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun Quadrants(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5F)
        ) {
            Quarter(
                title = stringResource(R.string.text_title),
                text = stringResource(R.string.text_text),
                color = 0xFFEADDFF,
                height = 0.5F
            )
            Quarter(
                title = stringResource(R.string.row_title),
                text = stringResource(R.string.row_text),
                color = 0xFFB69DF8,
                height = 1F
            )
        }
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
        {
            Quarter(
                title = stringResource(R.string.image_title),
                text = stringResource(R.string.image_text),
                color = 0xFFD0BCFF,
                height = 0.5F
            )
            Quarter(
                title = stringResource(R.string.column_title),
                text = stringResource(R.string.column_text),
                color = 0xFFF6EDFF,
                height = 1F
            )
        }
    }
}

@Composable
fun Quarter(
    title: String,
    text: String, color: Long,
    height: Float,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = Color(color))
            .fillMaxHeight(height)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Text(
            text = text,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuadrantsPreview() {
    ComposeQuadrantTheme {
        Quadrants(
            modifier = Modifier
            .padding(0.dp)
        )
    }
}