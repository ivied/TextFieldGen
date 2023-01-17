package com.coolhabit.textfieldgencompose.textField.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.coolhabit.textfieldgencompose.data.extensions.DOUBLE_REGEX

@Composable
fun DoubleInput(
    modifier: Modifier = Modifier,
    saveDouble: (Double) -> Unit,
) {
    var inputInt by remember { mutableStateOf("") }
    val pattern = remember { Regex(DOUBLE_REGEX) }

    TextField(
        value = inputInt,
        onValueChange = {
            if (it.isEmpty() || it.matches(pattern)) inputInt = it
            val double = if (it.isNotEmpty() && it.matches(pattern)) it.toDouble() else 0.0
            saveDouble(double)
        },
        modifier = modifier.width(150.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}
