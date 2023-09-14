package com.blc.coffeethemeui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blc.coffeethemeui.R
import com.blc.coffeethemeui.ui.models.Coffee

@Composable
fun CoffeeItem(coffee: Coffee, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier.defaultMinSize(minWidth = 80.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = coffee.image), contentDescription = null)
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = coffee.name, style = TextStyle(
                fontSize = 20.sp, fontFamily = FontFamily(Font(R.font.sen))
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = null,
                tint = Color(0xFFC69A80)
            )
        }
    }
}