package com.coolhabit.textfieldgencompose.textField.extensions

import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import com.coolhabit.textfieldgencompose.baseui.ui.theme.SteagalMedium
import com.coolhabit.textfieldgencompose.baseui.ui.theme.SteagalRegular
import com.coolhabit.textfieldgencompose.domain.entities.ColorRGB
import com.coolhabit.textfieldgencompose.domain.entities.PositionXY
import com.coolhabit.textfieldgencompose.domain.entities.ShadowType
import com.coolhabit.textfieldgencompose.domain.entities.SizeType
import com.coolhabit.textfieldgencompose.domain.entities.TextFieldSettings

fun emptyTextFieldSettings(): TextFieldSettings {
    return TextFieldSettings(
        "",
        null,
        ColorRGB(0, 0, 0, false),
        ColorRGB(0, 0, 0, false),
        0,
        0,
        ColorRGB(0, 0, 0, false),
        "",
        "",
        ColorRGB(0, 0, 0, false),
        null,
        false,
        null,
        0,
        false,
        false,
        null,
        0,
        0,
        0,
        0,
        null,
        PositionXY(0, 0, "", ""),
        0,
        0,
        0,
        false,
        false,
        ShadowType(
            ColorRGB(0, 0,0, false),
            0,
            0.0,
            0,
            SizeType(0, 0, 0, 0)
        ),
        SizeType(0, 0, 0 ,0),
        ColorRGB(0, 0, 0, false),
        0,
        null,
    )
}

fun String?.toAlign(): Alignment {
    return when (this) {
        "LEFT" -> Alignment.TopStart
        "RIGHT" -> Alignment.TopEnd
        "CENTER" -> Alignment.TopCenter
        else -> Alignment.TopStart
    }
}

fun String?.toFont(): FontFamily {
    return when (this) {
        "REGULAR" -> SteagalRegular
        "MEDIUM" -> SteagalMedium
        else -> FontFamily.Default
    }
}

fun String?.toKeyboardType(): KeyboardType {
    return when (this) {
        "NUMBER" -> KeyboardType.Number
        "TEXT" -> KeyboardType.Text
        "ASCII" -> KeyboardType.Ascii
        "PHONE" -> KeyboardType.Phone
        "URI" -> KeyboardType.Uri
        "EMAIL" -> KeyboardType.Email
        "PASSWORD" -> KeyboardType.Password
        "NUMBER_PASSWORD" -> KeyboardType.NumberPassword
        "DECIMAL" -> KeyboardType.Decimal
        else -> KeyboardType.Text
    }
}
