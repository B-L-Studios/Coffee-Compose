package com.blc.coffeethemeui.ui.models

import com.blc.coffeethemeui.R

data class Sugar(
    val selected: Int,
    val unselected: Int,
)

val listOfSugarCubes = listOf(
    Sugar(
        selected = R.drawable.no_sugar_sel,
        unselected = R.drawable.no_sugar_un
    ),
    Sugar(
        selected = R.drawable.one_sel,
        unselected = R.drawable.one_un
    ),
    Sugar(
        selected = R.drawable.two_sel,
        unselected = R.drawable.two_un
    ),
    Sugar(
        selected = R.drawable.three_sel,
        unselected = R.drawable.three_un
    )
)