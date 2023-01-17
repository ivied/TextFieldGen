package com.coolhabit.textfieldgencompose.textField.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import com.coolhabit.textfieldgencompose.baseui.extensions.MAX_INT_CHARS
import com.coolhabit.textfieldgencompose.baseui.extensions.toTrimInt
import com.coolhabit.textfieldgencompose.baseui.ui.theme.Purple200
import com.coolhabit.textfieldgencompose.domain.entities.AlignType
import com.coolhabit.textfieldgencompose.domain.entities.ColorRGB
import com.coolhabit.textfieldgencompose.domain.entities.FontType
import com.coolhabit.textfieldgencompose.domain.entities.URLType
import com.coolhabit.textfieldgencompose.domain.entities.UrlText

@Composable
fun UrlInput(
    modifier: Modifier = Modifier,
    saveUrl: (URLType) -> Unit,
) {

    var inputUrl by remember {
        mutableStateOf(
            URLType(
                "",
                UrlText(
                    "",
                    ColorRGB(0, 0, 0, false),
                    "",
                    "",
                    0,
                    ColorRGB(0, 0, 0, false),
                    0
                )
            )
        )
    }

    var inputRed by remember { mutableStateOf("") }
    var inputGreen by remember { mutableStateOf("") }
    var inputBlue by remember { mutableStateOf("") }
    var inputClear = remember { mutableStateOf(false) }

    var inputUnderlineRed by remember { mutableStateOf("") }
    var inputUnderlineGreen by remember { mutableStateOf("") }
    var inputUnderlineBlue by remember { mutableStateOf("") }
    var inputUnderlineClear = remember { mutableStateOf(false) }

    var inputContent by remember { mutableStateOf(TextFieldValue("")) }
    var inputUnderlineThick by remember { mutableStateOf("") }
    var inputFontSize by remember { mutableStateOf("") }

    val pattern = remember { Regex("^\\d+\$") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Content", modifier = Modifier.padding(top = 8.dp))
        TextField(
            value = inputContent,
            onValueChange = {
                inputContent = it
                inputUrl.urlText.content = it.text
                saveUrl(inputUrl)
            },
            modifier = modifier,
        )
        Text(text = "UnderlineThickness", modifier = Modifier.padding(top = 8.dp))
        TextField(
            value = inputUnderlineThick,
            onValueChange = { text ->
                if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputUnderlineThick = text
                val int = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                inputUrl.urlText.underlineThickness = int
                saveUrl(inputUrl)
            },
            modifier = modifier.width(150.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = "FontSize", modifier = Modifier.padding(top = 8.dp))
        TextField(
            value = inputFontSize,
            onValueChange = { text ->
                if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputFontSize = text
                val int = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                inputUrl.urlText.fontSize = int
                saveUrl(inputUrl)
            },
            modifier = modifier.width(150.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        DropDownInput(
            label = "Align",
            list = AlignType.values().toList().map { it.name },
            saveChoice = {
                inputUrl.urlText.alignType = it
                saveUrl(inputUrl)
            }
        )
        DropDownInput(
            label = "Font",
            list = FontType.values().toList().map { it.name },
            saveChoice = {
                inputUrl.urlText.font = it
                saveUrl(inputUrl)
            }
        )
        Text(text = "TextColor", modifier = Modifier.padding(top = 8.dp))
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
                    inputUrl.urlText.color?.red = red
                    saveUrl(inputUrl)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            TextField(
                value = inputGreen,
                label = {
                    androidx.compose.material3.Text(text = "Green", color = Purple200)
                },
                onValueChange = {
                    if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputGreen = it
                    val green = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                    inputUrl.urlText.color?.green = green
                    saveUrl(inputUrl)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = inputBlue,
                label = {
                    androidx.compose.material3.Text(text = "Blue", color = Purple200)
                },
                onValueChange = {
                    if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputBlue = it
                    val blue = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                    inputUrl.urlText.color?.blue = blue
                    saveUrl(inputUrl)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                androidx.compose.material3.Text(text = "clear", color = Purple200)
                Checkbox(
                    checked = inputClear.value,
                    onCheckedChange = {
                        inputClear.value = it
                        inputUrl.urlText.color?.clear = it
                        saveUrl(inputUrl)
                    }
                )
            }
        }
        Text(text = "UnderlineColor", modifier = Modifier.padding(top = 8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = inputUnderlineRed,
                label = {
                    Text(text = "Red", color = Purple200)
                },
                onValueChange = {
                    if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputUnderlineRed = it
                    val red = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                    inputUrl.urlText.underlineColor?.red = red
                    saveUrl(inputUrl)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            TextField(
                value = inputUnderlineGreen,
                label = {
                    Text(text = "Green", color = Purple200)
                },
                onValueChange = {
                    if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputUnderlineGreen = it
                    val green = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                    inputUrl.urlText.underlineColor?.green = green
                    saveUrl(inputUrl)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = inputUnderlineBlue,
                label = {
                    Text(text = "Blue", color = Purple200)
                },
                onValueChange = {
                    if (it.length <= MAX_COLOR_CHARS && (it.matches(pattern) || it.isEmpty())) inputUnderlineBlue = it
                    val blue = if (it.isNotEmpty() && it.matches(pattern)) it.toTrimInt(MAX_INT_CHARS) else 0
                    inputUrl.urlText.underlineColor?.blue = blue
                    saveUrl(inputUrl)
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
                    checked = inputUnderlineClear.value,
                    onCheckedChange = {
                        inputUnderlineClear.value = it
                        inputUrl.urlText.underlineColor?.clear = it
                        saveUrl(inputUrl)
                    }
                )
            }
        }
    }
}
