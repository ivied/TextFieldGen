package com.coolhabit.textfieldgencompose.textField.finish

import com.coolhabit.textfieldgencompose.domain.entities.TextFieldSettings

data class TextFieldState(
    val isLoading: Boolean = false,
    val settings: MutableList<TextFieldSettings> = mutableListOf(),
    val error: String = "",
)
