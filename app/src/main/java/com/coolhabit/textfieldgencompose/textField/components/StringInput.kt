package com.coolhabit.textfieldgencompose.textField.components

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun StringInput(
    modifier: Modifier = Modifier,
    saveString: (String) -> Unit,
) {
    var inputId by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = inputId,
        onValueChange = {
            inputId = it
            saveString(it.text)
        },
        modifier = modifier,
    )
}
