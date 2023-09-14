package com.blc.coffeethemeui.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.blc.coffeethemeui.R
import com.blc.coffeethemeui.ui.components.CoffeeItem
import com.blc.coffeethemeui.ui.models.listOfCoffees
import com.blc.coffeethemeui.ui.theme.TextAppColor

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = null,
                tint = Color.Unspecified
            )

            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("It's Great ")
                }
                withStyle(style = SpanStyle(color = TextAppColor, fontWeight = FontWeight.Bold)) {
                    append("Day For Coffee")
                }
            }, style = TextStyle(
                fontSize = 36.sp, lineHeight = 48.sp, fontFamily = FontFamily(Font(R.font.sen))
            )
        )

        Spacer(modifier = Modifier.height(28.dp))

        LazyColumn {
            items(listOfCoffees) { coffee ->
                CoffeeItem(coffee = coffee, onClick = {
                    navController.navigate("detail")
                })
            }
        }
    }
}