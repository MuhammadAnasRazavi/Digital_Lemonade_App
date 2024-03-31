package com.example.digitallemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var squeezeCount by remember {
        mutableIntStateOf(0)
    }

    var result by remember {
        mutableIntStateOf(1)
    }

    var squeezeTime by remember {
        mutableIntStateOf((2..4).random())
    }

    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val instructionResource = when (result) {
        1 -> R.string.lemon_tree_instruction
        2 -> R.string.lemon_squeeze_instruction
        3 -> R.string.lemonade_drink_instruction
        else -> R.string.empty_glass_instruction
    }

    val descriptionResource = when (result) {
        1 -> R.string.lemon_tree_text
        2 -> R.string.lemon_text
        3 -> R.string.lemonade_text
        else -> R.string.empty_glass_text
    }

    var firstTime by remember {
        mutableStateOf(true)
    }

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
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = descriptionResource),
            modifier = Modifier
                .height(350.dp)
                .width(300.dp)
                .border(
                    width = 2.dp,
                    shape = RoundedCornerShape(
                        topStart = 50.dp, topEnd = 25.dp, bottomStart = 25.dp, bottomEnd = 50.dp
                    ),
                    color = Color(105, 205, 216)
                )
                .clip(
                    RoundedCornerShape(
                        topStart = 50.dp, topEnd = 25.dp, bottomStart = 25.dp, bottomEnd = 50.dp
                    )
                )
                .background(Color(0xFFc4ecd2))
                .clickable {
                    result = when (result) {
                        1, 3 -> result + 1
                        2 -> {
                            squeezeCount += 1
                            if (squeezeCount != squeezeTime) {
                                2
                            } else {
                                squeezeCount = 0
                                squeezeTime = (2..4).random()
                                3
                            }
                        }

                        else -> 1
                    }
                }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = instructionResource), fontSize = 18.sp
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