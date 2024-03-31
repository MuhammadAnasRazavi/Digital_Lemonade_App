package com.example.digitallemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitallemonadeapp.ui.theme.DigitalLemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigitalLemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    DigitalLemonadeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DigitalLemonadeApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color(0xFFf9e44b))
        )
        Spacer(modifier = Modifier.height(125.dp))
        Image(
            painter = painterResource(id = R.drawable.lemon_tree),
            contentDescription = stringResource(id = R.string.lemon_tree_text),
            modifier = Modifier
                .height(350.dp)
                .width(300.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 75.dp, topEnd = 30.dp, bottomStart = 30.dp, bottomEnd = 75.dp
                    )
                )
                .background(Color(0xFFc4ecd2))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.lemon_tree_instruction), fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DigitalLemonadePreview() {
    DigitalLemonadeAppTheme {
        DigitalLemonadeApp()
    }
}