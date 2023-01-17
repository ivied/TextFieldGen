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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.coolhabit.textfieldgencompose.baseui.extensions.MAX_COLOR_CHARS
import com.coolhabit.textfieldgencompose.baseui.extensions.MAX_DOUBLE_CHARS
import com.coolhabit.textfieldgencompose.baseui.extensions.MAX_INT_CHARS
import com.coolhabit.textfieldgencompose.baseui.extensions.toTrimInt
import com.coolhabit.textfieldgencompose.baseui.ui.theme.Purple200
import com.coolhabit.textfieldgencompose.domain.entities.ColorRGB
import com.coolhabit.textfieldgencompose.domain.entities.ShadowType
import com.coolhabit.textfieldgencompose.domain.entities.SizeType

@Composable
fun ShadowInput(
    modifier: Modifier = Modifier,
    saveShadow: (ShadowType) -> Unit,
) {
    var inputShadow by remember {
        mutableStateOf(
            ShadowType(
                ColorRGB(0, 0, 0, false),
                0,
                0.0,
                0,
                SizeType(0, 0, 0, 0)
            )
        )
    }
    var inputRed by remember { mutableStateOf("") }
    var inputGreen by remember { mutableStateOf("") }
    var inputBlue by remember { mutableStateOf("") }
    var inputClear = remember { mutableStateOf(false) }

    var inputHeight by remember { mutableStateOf("") }
    var inputWidth by remember { mutableStateOf("") }
    var inputMinHeight by remember { mutableStateOf("") }
    var inputMinWidth by remember { mutableStateOf("") }

    var inputOffset by remember { mutableStateOf("") }
    var inputOpacity by remember { mutableStateOf("") }
    var inputRadius by remember { mutableStateOf("") }

    val pattern = remember { Regex("^\\d+\$") }
    val doublePattern = remember { Regex("^[0-9]+\\.?[0-9]*\$") }


    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = inputRed,
                label = {
                    Text(text = "Red", color = Purple200)
                },
                onValueChange = {
                    if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputRed = it
                    val red = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                    inputShadow.shadowColor.red = red
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            TextField(
                value = inputGreen,
                label = {
                    Text(text = "Green", color = Purple200)
                },
                onValueChange = {
                    if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputGreen = it
                    val green = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                    inputShadow.shadowColor.green = green
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = inputBlue,
                label = {
                    Text(text = "Blue", color = Purple200)
                },
                onValueChange = {
                    if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputBlue = it
                    val blue = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                    inputShadow.shadowColor.blue = blue
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "clear", color = Purple200)
                Checkbox(
                    checked = inputClear.value,
                    onCheckedChange = {
                        inputClear.value = it
                        inputShadow.shadowColor.clear = it
                        saveShadow(inputShadow)
                    }
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = inputHeight,
                label = {
                    Text(text = "Height", color = Purple200)
                },
                onValueChange = { text ->
                    if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputHeight = text
                    val height = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                    inputShadow.shadowSizeType?.height = height
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(85.dp)
                    .padding(horizontal = 4.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            TextField(
                value = inputWidth,
                label = {
                    Text(text = "Width", color = Purple200)
                },
                onValueChange = { text ->
                    if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputWidth = text
                    val width = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                    inputShadow.shadowSizeType?.width = width
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(85.dp)
                    .padding(horizontal = 4.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = inputMinHeight,
                label = {
                    Text(text = "MinHeight", color = Purple200)
                },
                onValueChange = { text ->
                    if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputMinHeight = text
                    val minHeight = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                    inputShadow.shadowSizeType?.minHeight = minHeight
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(120.dp)
                    .padding(horizontal = 4.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = inputMinWidth,
                label = {
                    Text(text = "MinWidth", color = Purple200)
                },
                onValueChange = { text ->
                    if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputMinWidth = text
                    val minWidth = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                    inputShadow.shadowSizeType?.minWidth = minWidth
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(110.dp)
                    .padding(horizontal = 4.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = inputOffset,
                label = {
                    Text(text = "Offset", color = Purple200)
                },
                onValueChange = { text ->
                    if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputOffset = text
                    val offset = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                    inputShadow.shadowOffset = offset
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 4.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            TextField(
                value = inputOpacity,
                label = {
                    Text(text = "Opacity", color = Purple200)
                },
                onValueChange = { text ->
                    if (text.length <= MAX_INT_CHARS && (text.matches(doublePattern) || text.isEmpty())) inputOpacity = text
                    val opacity = if (text.isNotEmpty() && text.matches(doublePattern)) text.toDouble() else 0.0
                    inputShadow.shadowOpacity = opacity.toDouble()
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 4.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            TextField(
                value = inputRadius,
                label = {
                    Text(text = "Radius", color = Purple200)
                },
                onValueChange = { text ->
                    if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputRadius = text
                    val radius = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                    inputShadow.shadowRadius = radius
                    saveShadow(inputShadow)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 4.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
    }
}
