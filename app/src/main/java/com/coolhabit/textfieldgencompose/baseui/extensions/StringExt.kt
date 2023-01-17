package com.coolhabit.textfieldgencompose.baseui.extensions

fun String.toTrimInt(chars: Int): Int {
    return this.filter { char -> char.isDigit() }.take(chars)
        .toInt()
}
