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
                    Budget(
                        name = "Cool Add Placeholder",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Budget(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(10.dp))

        Total(modifier = Modifier)

        Spacer(modifier = Modifier.height(70.dp))

        Buttons(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(20.dp))
    }

}


@Composable
fun Total(modifier: Modifier) {
    var totalMoney = 0
    Row {
        
        Row(modifier = Modifier
            .padding(10.dp)) {
            Text(text = "$totalMoney",
                fontSize = 37.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,

                modifier = modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(color = Color.Blue)
                    .width(100.dp)
            )
        }


        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(10.dp)) {
            Text(text = "savings")
        }
    }
}



@Composable
fun Buttons(modifier: Modifier) {

    Row {
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(10.dp)) {
            Text(text = "+",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(50.dp)
                    .height(30.dp)
            )
        }

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(10.dp)) {
            Text(text = "-",
                fontSize = 30.sp,
                textAlign =  TextAlign.Center,
                modifier = Modifier
                    .width(50.dp)
                    .height(30.dp)
                )
        }
    }
}

@Composable
fun Listofsums(modifier: Modifier) {


}








@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BudgetingTheme {
        Budget("Android")
    }
}