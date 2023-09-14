package com.blc.coffeethemeui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.blc.coffeethemeui.R

@Composable
fun MinusBtn(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    bottomStart = 20.dp
                )
            )
            .background(color = Color(0xFFC69A80))
            .clickable {
                onClick()
            }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_remove_24),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.padding(2.dp)
        )
    }
}

@Composable
fun AddBtn(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topEnd = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .background(color = Color(0xFFC69A80))
            .clickable {
                onClick()
            }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_add_24),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.padding(2.dp)
        )
    }
}