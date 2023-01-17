package com.coolhabit.textfieldgencompose.textField.components

import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun BooleanInput(
    saveBoolean: (Boolean) -> Unit,
) {
    var inputBoolean = remember { mutableStateOf(false) }

    Checkbox(
        checked = inputBoolean.value,
        onCheckedChange = {
            inputBoolean.value = it
            saveBoolean(it)
        }
    )
}
