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
import com.coolhabit.textfieldgencompose.baseui.extensions.MAX_INT_CHARS
import com.coolhabit.textfieldgencompose.baseui.extensions.toTrimInt
import com.coolhabit.textfieldgencompose.data.extensions.INT_REGEX

@Composable
fun IntInput(
    modifier: Modifier = Modifier,
    saveInt: (Int) -> Unit,
) {
    var inputInt by remember { mutableStateOf("") }
    val pattern = remember { Regex(INT_REGEX) }

    TextField(
        value = inputInt,
        onValueChange = { text ->
            if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputInt = text
            val int = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
            saveInt(int)
        },
        modifier = modifier.width(150.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}
