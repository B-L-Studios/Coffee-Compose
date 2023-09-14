package com.blc.coffeethemeui.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SugarBox(
    selectedImage: Int,
    unselectedImage: Int,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    val image = if (isSelected) selectedImage else unselectedImage
    Column(
        modifier = Modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null
        )

        Box(modifier = Modifier.height(4.dp))

        if (isSelected)
            Indicator()
    }
}