package com.coolhabit.textfieldgencompose.textField.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.coolhabit.textfieldgencompose.data.extensions.INT_REGEX
import com.coolhabit.textfieldgencompose.data.extensions.X
import com.coolhabit.textfieldgencompose.data.extensions.XREL
import com.coolhabit.textfieldgencompose.data.extensions.Y
import com.coolhabit.textfieldgencompose.data.extensions.YREL
import com.coolhabit.textfieldgencompose.domain.entities.PositionXY
import com.coolhabit.textfieldgencompose.domain.entities.XRel
import com.coolhabit.textfieldgencompose.domain.entities.YRel

@Composable
fun PositionInput(
    modifier: Modifier = Modifier,
    savePosition: (PositionXY) -> Unit,
) {

    val pattern = remember { Regex(INT_REGEX) }

    var inputPosition by remember {
        mutableStateOf(
            PositionXY(
                0,
                0,
                "",
                ""
            )
        )
    }
    var inputX by remember { mutableStateOf("") }
    var inputY by remember { mutableStateOf("") }
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextField(
                value = inputX,
                label = {
                    Text(text = X, color = Purple200)
                },
                onValueChange = { text ->
                    if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputX = text
                    val x = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                    inputPosition.x = x
                    savePosition(inputPosition)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            TextField(
                value = inputY,
                label = {
                    Text(text = Y, color = Purple200)
                },
                onValueChange = { text ->
                    if (text.length <= MAX_INT_CHARS && (text.matches(pattern) || text.isEmpty())) inputY = text
                    val y = if (text.isNotEmpty() && text.matches(pattern)) text.toTrimInt(MAX_INT_CHARS) else 0
                    inputPosition.y = y
                    savePosition(inputPosition)
                },
                modifier = modifier
                    .width(100.dp)
                    .padding(horizontal = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }
        DropDownInput(
            label = XREL,
            list = XRel.values().toList().map { it.name },
            saveChoice = {
                inputPosition.xRel = it
                savePosition(inputPosition)
            }
        )
        DropDownInput(
            label = YREL,
            list = YRel.values().toList().map { it.name },
            saveChoice = {
                inputPosition.yRel = it
                savePosition(inputPosition)
            }
        )
    }
}
