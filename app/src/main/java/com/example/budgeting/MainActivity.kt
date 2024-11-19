package com.example.budgeting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgeting.ui.theme.BudgetingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BudgetingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    budget(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun budget(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(20.dp))

        total(modifier = Modifier)

        Spacer(modifier = Modifier.height(100.dp))

        buttons(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(20.dp))
    }

}


@Composable
fun total(modifier: Modifier) {
    var totalMoney = 0
    Row {
        Text(text = "$totalMoney",
            fontSize = 40.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,

            modifier = modifier
                .clip(RoundedCornerShape(30.dp))
                .background(color = Color.Blue)
                .width(100.dp)


            )

        Spacer(Modifier.width(40.dp))

        Button(onClick = { /*TODO*/ }) {
            Text(text = "savings")
        }
    }
}



@Composable
fun buttons(modifier: Modifier) {

    Row {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "add Money",
                fontSize = 10.sp,
                modifier = Modifier
                    .width(30.dp))
        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "subtract Money",
                fontSize = 10.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BudgetingTheme {
        budget("Android")
    }
}