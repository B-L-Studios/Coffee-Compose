package com.blc.coffeethemeui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.blc.coffeethemeui.R
import com.blc.coffeethemeui.ui.components.AddBtn
import com.blc.coffeethemeui.ui.components.MinusBtn
import com.blc.coffeethemeui.ui.components.SugarBox
import com.blc.coffeethemeui.ui.models.listOfSugarCubes
import com.blc.coffeethemeui.ui.theme.AppBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController) {
    val quantity = remember { mutableStateOf(1) }
    val price = remember { mutableStateOf(4) }

    val selectedCube = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Macchiato",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            color = Color(0xFF8C746A),
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.sen)),
                            fontWeight = FontWeight.Bold
                        ),
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowLeft,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(0xFF8C746A)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AppBackground
                ),
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 40.dp, bottomEnd = 40.dp
                        )
                    )
                    .weight(1f)
                    .background(color = AppBackground)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.macciato),
                    contentDescription = null,
                    modifier = Modifier.aspectRatio(3f)
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                        .fillMaxSize()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Macchiato",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.sen)),
                            )
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        MinusBtn {
                            if (quantity.value > 1) {
                                quantity.value -= 1
                            }
                        }

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = quantity.value.toString(),
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.sen))
                            )
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        AddBtn {
                            if (quantity.value < 10) {
                                quantity.value += 1
                            }
                        }

                    }

                    Text(
                        text = "${price.value * quantity.value}$", style = TextStyle(
                            color = Color(0xFFCF9775),
                            fontSize = 30.sp,
                            fontFamily = FontFamily(Font(R.font.sen)),
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Black)) {
                                append("Sugar ")
                            }
                            withStyle(style = SpanStyle(color = Color.Gray)) {
                                append("(in cubes)")
                            }
                        },
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.sen)),
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        items(listOfSugarCubes) { sugar ->
                            SugarBox(
                                selectedImage = sugar.selected,
                                unselectedImage = sugar.unselected,
                                isSelected = selectedCube.value == listOfSugarCubes.indexOf(sugar),
                                onClick = {
                                    selectedCube.value = listOfSugarCubes.indexOf(sugar)
                                }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    TextButton(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFCF9775)
                        ),
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                        contentPadding = PaddingValues(18.dp)
                    ) {
                        Text(
                            text = "Add to cart",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.sen))
                            )
                        )
                    }
                }
            }
        }
    }
}