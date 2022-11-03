package com.varma.hemanshu.androidlearninspire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        modifier = Modifier
            .padding(all = 16.dp)
    ) {
        Spacer(modifier = Modifier.size(72.dp))
        Image(
            painter = painterResource(id = R.drawable.icon_profile),
            contentDescription = "profile image",
            modifier = Modifier
                .size(72.dp)
        )
        Text(
            text = stringResource(id = R.string.user_name),
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.user_bio),
            modifier = Modifier.padding(top = 16.dp),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.size(32.dp))
        Footer()
    }
}

@Composable
fun Footer() {
    Row(
        modifier = Modifier.fillMaxWidth(),
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
            contentDescription = "twitter logo"
        )
        Image(
            painter = painterResource(id = R.drawable.icon_youtube),
            contentDescription = "youtube logo"
        )
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