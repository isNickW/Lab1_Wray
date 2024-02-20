package com.example.lab1_wray

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1_wray.ui.theme.Lab1_WrayTheme

//hot garbage
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1_WrayTheme {
                // A surface container using the 'background' color from the theme
                //contains the Display() function
                Surface {
                    Display(name = stringResource(R.string.greeting_with_name), description = stringResource(
                        R.string.description), interests = stringResource(R.string.interests_cat))
                }
            }
        }
    }
}

//Content() composable containing text and image content that will be added to the display
@Composable
fun Content(name: String, description: String, interests: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bacon)
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ){
        //app name
        Text(
            text = stringResource(R.string.app_name),
            fontFamily = FontFamily.Serif,
            fontSize = 70.sp,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 50.dp)
        )
        //name text
        Text(
            text = name,
            fontFamily = FontFamily.Serif,
            fontSize = 45.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(15.dp)
                .background(color = Color.LightGray)
        )
        //description text
        Text(
            text = description,
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            modifier = modifier
        )
        //interests text(cat)
        Text(
            text = interests,
            fontFamily = FontFamily.Serif,
            fontSize = 20.sp,
            modifier = modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally)
        )
        //image composable containing a picture of my cat
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

//
//Display() composable containing a background image and calling Content() function
@Composable
fun Display(name: String, description: String, interests: String, modifier: Modifier = Modifier) {
    val backgroundImage = painterResource(R.drawable.space)
    Box {
        //background image
        Image(
            painter = backgroundImage,
            contentDescription = null,
            alpha = 0.5F,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        //Content() function
        Content(
            name = name,
            description = description,
            interests = interests,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab1_WrayTheme {
        Display(name = stringResource(R.string.greeting_with_name), description = stringResource(R.string.description), interests = stringResource(
            R.string.interests_cat
        )
        )
    }
}
