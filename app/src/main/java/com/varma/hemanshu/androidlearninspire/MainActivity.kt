package com.varma.hemanshu.androidlearninspire

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varma.hemanshu.androidlearninspire.ui.theme.AndroidLearnInspireTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidLearnInspireTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .size(144.dp),
            painter = painterResource(id = R.drawable.blackadam),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(id = R.string.user_name),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.user_bio),
            modifier = Modifier.padding(top = 16.dp),
            textAlign = TextAlign.Justify
        )
        Footer()
    }
}

@Composable
fun Footer() {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_facebook),
            contentDescription = "facebook logo"
        )
        Image(
            painter = painterResource(id = R.drawable.icon_whatsapp),
            contentDescription = "whatsapp logo"
        )
        Image(
            painter = painterResource(id = R.drawable.icon_twitter),
            contentDescription = "twitter logo",
            modifier = Modifier.clickable {
                Toast.makeText(context, "Twitter", Toast.LENGTH_SHORT).show()
            }
        )
        IconButton(onClick = {
            Toast.makeText(context, "YouTube", Toast.LENGTH_SHORT).show()
        }) {
            Image(
                painter = painterResource(id = R.drawable.icon_youtube),
                contentDescription = "youtube logo"
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidLearnInspireTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AndroidLearnInspireTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun FooterPreview() {
    AndroidLearnInspireTheme {
        Footer()
    }
}