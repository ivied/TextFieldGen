package com.coolhabit.textfieldgencompose.textField.second

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coolhabit.textfieldgencompose.domain.entities.AlignType
import com.coolhabit.textfieldgencompose.domain.entities.FontType
import com.coolhabit.textfieldgencompose.domain.entities.KeyboardType
import com.coolhabit.textfieldgencompose.textField.components.DoubleInput
import com.coolhabit.textfieldgencompose.textField.TextFieldGenViewModel
import com.coolhabit.textfieldgencompose.textField.components.BooleanInput
import com.coolhabit.textfieldgencompose.textField.components.ColorInput
import com.coolhabit.textfieldgencompose.textField.components.DropDownInput
import com.coolhabit.textfieldgencompose.textField.components.IntInput
import com.coolhabit.textfieldgencompose.textField.components.PositionInput
import com.coolhabit.textfieldgencompose.textField.components.ShadowInput
import com.coolhabit.textfieldgencompose.textField.components.SizeInput
import com.coolhabit.textfieldgencompose.textField.components.StringInput
import com.coolhabit.textfieldgencompose.textField.components.UrlInput

@Composable
fun SecondTextFieldScreen(
    viewModel: TextFieldGenViewModel,
) {
    LazyColumn() {
        item {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Input for Field 2", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                DropDownInput(
                    label = "Align",
                    list = AlignType.values().toList().map { it.name },
                    saveChoice = {
                        viewModel.setAlign(it)
                    }
                )
                DropDownInput(
                    label = "Font",
                    list = FontType.values().toList().map { it.name },
                    saveChoice = {
                        viewModel.setFont(it)
                    }
                )
                DropDownInput(
                    label = "KeyboardType",
                    list = KeyboardType.values().toList().map { it.name },
                    saveChoice = {
                        viewModel.setKeyboardType(it)
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Identifier")
                StringInput(
                    saveString = { id ->
                        viewModel.setId(id)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "Content", modifier = Modifier.padding(top = 8.dp))
                StringInput(
                    saveString = { content ->
                        viewModel.setContent(content)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "Placeholder", modifier = Modifier.padding(top = 8.dp))
                StringInput(
                    saveString = { placeholder ->
                        viewModel.setPlaceholder(placeholder)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "NextResponder", modifier = Modifier.padding(top = 8.dp))
                StringInput(
                    saveString = { placeholder ->
                        viewModel.setNextResponder(placeholder)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "BackgroundColor", modifier = Modifier.padding(top = 8.dp))
                ColorInput(
                    saveColor = {
                        viewModel.setBackgroundColor(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "TextColor", modifier = Modifier.padding(top = 8.dp))
                ColorInput(
                    saveColor = {
                        viewModel.setTextColor(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "BorderColor", modifier = Modifier.padding(top = 8.dp))
                ColorInput(
                    saveColor = {
                        viewModel.setBorderColor(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "PlaceholderTextColor", modifier = Modifier.padding(top = 8.dp))
                ColorInput(
                    saveColor = {
                        viewModel.setPlaceholderTextColor(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "UnderlineColor", modifier = Modifier.padding(top = 8.dp))
                ColorInput(
                    saveColor = {
                        viewModel.setUnderlineColor(it)
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(text = "Size", modifier = Modifier.padding(top = 8.dp))
                SizeInput(
                    saveSize = {
                        viewModel.setSize(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "BottomPadding", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setBottomPadding(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "LeftPadding", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setLeftPadding(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "RightPadding", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setRightPadding(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "RimPadding", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setRimPadding(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "BorderWidth", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setBorderWidth(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "FontSize", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setFontSize(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "Lines", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setLines(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "MaxStroke", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setMaxStroke(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "Radius", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setRadius(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "UnderlineThickness", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setUnderlineThickness(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "ExecutionDelay", modifier = Modifier.padding(top = 8.dp))
                DoubleInput(
                    saveDouble = {
                        viewModel.setExecutionDelay(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "LineSpace", modifier = Modifier.padding(top = 8.dp))
                IntInput(
                    saveInt = {
                        viewModel.setLineSpace(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "FirstResponder", modifier = Modifier.padding(top = 8.dp))
                BooleanInput(
                    saveBoolean = {
                        viewModel.setFirstResponder(it)
                    }
                )
                Text(text = "Input", modifier = Modifier.padding(top = 8.dp))
                BooleanInput(
                    saveBoolean = {
                        viewModel.setInput(it)
                    }
                )
                Text(text = "InputFieldHeightDynamic", modifier = Modifier.padding(top = 8.dp))
                BooleanInput(
                    saveBoolean = {
                        viewModel.setInputFieldHeightDynamic(it)
                    }
                )
                Text(text = "Scrollable", modifier = Modifier.padding(top = 8.dp))
                BooleanInput(
                    saveBoolean = {
                        viewModel.setScrollable(it)
                    }
                )
                Text(text = "SecureText", modifier = Modifier.padding(top = 8.dp))
                BooleanInput(
                    saveBoolean = {
                        viewModel.setSecureText(it)
                    }
                )
                Text(text = "Shadow", modifier = Modifier.padding(top = 8.dp), fontWeight = FontWeight.Bold)
                ShadowInput(
                    saveShadow = {
                        viewModel.setShadow(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "Position", modifier = Modifier.padding(top = 8.dp), fontWeight = FontWeight.Bold)
                PositionInput(
                    savePosition = {
                        viewModel.setPosition(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(text = "URL", modifier = Modifier.padding(top = 8.dp), fontWeight = FontWeight.Bold)
                UrlInput(
                    saveUrl = {
                        viewModel.setUrl(it)
                    },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Button(
                    onClick = {
                        viewModel.navigateToThirdTextFieldSettings()
                    }
                ) {
                    Text(text = "Go to 3")
                }
            }
        }
    }
}
