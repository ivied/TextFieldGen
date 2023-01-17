package com.coolhabit.textfieldgencompose.textField.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Checkbox
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.coolhabit.textfieldgencompose.baseui.extensions.MAX_COLOR_CHARS
import com.coolhabit.textfieldgencompose.baseui.extensions.MAX_INT_CHARS
import com.coolhabit.textfieldgencompose.baseui.extensions.toTrimInt
import com.coolhabit.textfieldgencompose.baseui.ui.theme.Purple200
import com.coolhabit.textfieldgencompose.data.extensions.BLUE
import com.coolhabit.textfieldgencompose.data.extensions.CLEAR
import com.coolhabit.textfieldgencompose.data.extensions.GREEN
import com.coolhabit.textfieldgencompose.data.extensions.INT_REGEX
import com.coolhabit.textfieldgencompose.data.extensions.RED
import com.coolhabit.textfieldgencompose.domain.entities.ColorRGB

@Composable
fun ColorInput(
    modifier: Modifier = Modifier,
    saveColor: (ColorRGB) -> Unit,
) {
    var inputColor by remember { mutableStateOf(ColorRGB(0, 0, 0, false)) }
    var inputRed by remember { mutableStateOf("") }
    var inputGreen by remember { mutableStateOf("") }
    var inputBlue by remember { mutableStateOf("") }
    var inputClear = remember { mutableStateOf(false) }

    val pattern = remember { Regex(INT_REGEX) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        TextField(
            value = inputRed,
            label = {
                Text(text = RED, color = Purple200)
            },
            onValueChange = {
                if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputRed = it
                val red = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                inputColor.red = red
                saveColor(inputColor)
            },
            modifier = modifier
                .width(100.dp)
                .padding(horizontal = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        TextField(
            value = inputGreen,
            label = {
                Text(text = GREEN, color = Purple200)
            },
            onValueChange = {
                if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputGreen = it
                val green = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                inputColor.green = green
                saveColor(inputColor)
            },
            modifier = modifier
                .width(100.dp)
                .padding(horizontal = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = inputBlue,
            label = {
                Text(text = BLUE, color = Purple200)
            },
            onValueChange = {
                if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputBlue = it
                val blue = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                inputColor.blue = blue
                saveColor(inputColor)
            },
            modifier = modifier
                .width(100.dp)
                .padding(horizontal = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = CLEAR, color = Purple200)
            Checkbox(
                checked = inputClear.value,
                onCheckedChange = {
                    inputClear.value = it
                    inputColor.clear = it
                    saveColor(inputColor)
                }
            )
        }
    }
}
