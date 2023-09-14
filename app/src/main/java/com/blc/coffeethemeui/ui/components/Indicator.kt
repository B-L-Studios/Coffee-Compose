package com.blc.coffeethemeui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Indicator() {
    Box(
        modifier = Modifier
            .width(18.dp)
            .height(4.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(Color(0xFFCF9775))
    )
}