package com.blc.coffeethemeui.ui.models

import com.blc.coffeethemeui.R

data class Coffee(
    val name: String,
    val image: Int,
)

val listOfCoffees = listOf(
    Coffee(
        name = "Espresso", image = R.drawable.espresso
    ), Coffee(
        name = "Cappuccino", image = R.drawable.cappuccino
    ), Coffee(
        name = "Macchiato", image = R.drawable.macciato
    ), Coffee(
        name = "Mocha", image = R.drawable.mocha
    ), Coffee(
        name = "Latte", image = R.drawable.latte
    )
)