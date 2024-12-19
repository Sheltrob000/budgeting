package com.example.budgeting

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
    var totalMoney by remember { mutableDoubleStateOf(0.00) }
    var textAddMoney by remember { mutableStateOf("") }
    var textSubMoney by remember { mutableStateOf("") }
    var savingsDeduction by remember { mutableDoubleStateOf(0.0) }
    var savings by remember { mutableDoubleStateOf(0.00) }

    fun PutMoneyToTotal(numberAdd: Double, numberSub: Double) {
        val trueNumber = numberAdd * savingsDeduction
        totalMoney += trueNumber - numberSub
        savings = numberAdd - trueNumber
        Log.d("isWorking", "this function is running")
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Total(modifier = Modifier, total = totalMoney)

        Spacer(modifier = Modifier.height(70.dp))

//        TextBoxes(
//            addMoneyText = textAddMoney,
//            subMoneyText = textSubMoney,
//            onAddMoneyChange = { textAddMoney = it },
//            onSubMoneyChange = { textSubMoney = it },
//            putMoneyToTotal = {
//                PutMoneyToTotal(
//                    numberAdd = textAddMoney.toDouble(),
//                    numberSub = textSubMoney.toDouble()
//                )
//            }
//        )


        NewTextFields(
            moneyToAdd = textAddMoney,
            onAddChange = { textAddMoney = it },
            moneyToSub = textSubMoney,
            onSubChange = { textSubMoney = it },
            putMoneyToTotal = {
                PutMoneyToTotal(
                    numberAdd = textAddMoney.toDouble(),
                    numberSub = textSubMoney.toDouble()) }
            )

        Spacer(modifier = Modifier.height(20.dp))

        ListOfActions(modifier = Modifier)
    }

}


@Composable
fun Total(modifier: Modifier, total: Double) {
    Row {

        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = "$total",
                fontSize = 37.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,

                modifier = modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(color = Color.Gray)
                    .width(100.dp)
            )
        }


        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = "savings")
        }
    }
}


@Composable
fun TextBoxes(
    addMoneyText: String, onAddMoneyChange: (String) -> Unit,
    subMoneyText: String, onSubMoneyChange: (String) -> Unit,
    putMoneyToTotal: () -> Unit
) {


    Row {

        OutlinedTextField(
            value = addMoneyText,
            onValueChange = { onAddMoneyChange },
            label = { Text("+") },
            modifier = Modifier
                .width(100.dp)
        )

        Button(
            onClick = { putMoneyToTotal },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = "Add",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(50.dp)
                    .height(40.dp)
            )
        }

        OutlinedTextField(
            value = subMoneyText,
            onValueChange = { onSubMoneyChange },
            label = { Text("-") },
            modifier = Modifier
                .width(100.dp)
        )

    }
}


@Composable
fun ListOfActions(modifier: Modifier) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(100.dp)
            .width(250.dp)
            .background(color = Color.Gray)
            .padding(20.dp)
            .fillMaxSize(.5f)


    ) {
    }
}

@Composable
fun NewTextFields(
    moneyToAdd: String,
    onAddChange: (String) -> Unit,
    moneyToSub: String,
    onSubChange: (String) -> Unit,
    putMoneyToTotal: () -> Unit
) {
    Row(modifier = Modifier.padding(16.dp)) {
//        Text(
//            text = "Hello, $name",
//            modifier = Modifier.padding(bottom = 8.dp),
//            style = MaterialTheme.typography.bodyMedium
//        )
        OutlinedTextField(
            value = moneyToAdd,
            onValueChange = onAddChange,
            label = { Text("+") },
            modifier = Modifier.width(100.dp)
        )
        Button(
            onClick = { putMoneyToTotal },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = "Add",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(50.dp)
                    .height(40.dp)
            )
        }
        OutlinedTextField(
            value = moneyToSub,
            onValueChange = onSubChange,
            label = { Text("-") },
            modifier = Modifier.width(100.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BudgetingTheme {
        Budget("woo super add placr")
    }
}