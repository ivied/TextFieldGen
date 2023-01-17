package com.coolhabit.textfieldgencompose.textField.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.Text
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
import com.coolhabit.textfieldgencompose.baseui.ui.theme.Purple200
import com.coolhabit.textfieldgencompose.data.extensions.HEIGHT
import com.coolhabit.textfieldgencompose.data.extensions.INT_REGEX
import com.coolhabit.textfieldgencompose.data.extensions.MIN_HEIGHT
import com.coolhabit.textfieldgencompose.data.extensions.MIN_WIDTH
import com.coolhabit.textfieldgencompose.data.extensions.WIDTH
import com.coolhabit.textfieldgencompose.domain.entities.SizeType

@Composable
fun SizeInput(
    modifier: Modifier = Modifier,
    saveSize: (SizeType) -> Unit,
) {
    var inputSize by remember { mutableStateOf(SizeType(0, 0, 0, 0)) }
    var inputHeight by remember { mutableStateOf("") }
    var inputWidth by remember { mutableStateOf("") }
    var inputMinHeight by remember { mutableStateOf("") }
    var inputMinWidth by remember { mutableStateOf("") }

    val pattern = remember { Regex(INT_REGEX) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        TextField(
            value = inputHeight,
            label = {
                Text(text = HEIGHT, color = Purple200)
            },
            onValueChange = { text ->
                if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputHeight = text
                val height = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                inputSize.height = height
                saveSize(inputSize)
            },
            modifier = modifier
                .width(85.dp)
                .padding(horizontal = 4.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        TextField(
            value = inputWidth,
            label = {
                Text(text = WIDTH, color = Purple200)
            },
            onValueChange = { text ->
                if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputWidth = text
                val width = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                inputSize.width = width
                saveSize(inputSize)
            },
            modifier = modifier
                .width(85.dp)
                .padding(horizontal = 4.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = inputMinHeight,
            label = {
                Text(text = MIN_HEIGHT, color = Purple200)
            },
            onValueChange = { text ->
                if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputMinHeight = text
                val minHeight = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                inputSize.minHeight = minHeight
                saveSize(inputSize)
            },
            modifier = modifier
                .width(120.dp)
                .padding(horizontal = 4.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = inputMinWidth,
            label = {
                Text(text = MIN_WIDTH, color = Purple200)
            },
            onValueChange = { text ->
                if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputMinWidth = text
                val minWidth = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                inputSize.minWidth = minWidth
                saveSize(inputSize)
            },
            modifier = modifier
                .width(110.dp)
                .padding(horizontal = 4.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}
