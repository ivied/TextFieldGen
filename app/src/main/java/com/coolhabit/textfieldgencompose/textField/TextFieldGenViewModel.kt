package com.coolhabit.textfieldgencompose.textField

import com.coolhabit.textfieldgencompose.baseui.presentation.BaseViewModel
import com.coolhabit.textfieldgencompose.domain.api.ILocalStorage
import com.coolhabit.textfieldgencompose.domain.entities.ColorRGB
import com.coolhabit.textfieldgencompose.domain.entities.PositionXY
import com.coolhabit.textfieldgencompose.domain.entities.ShadowType
import com.coolhabit.textfieldgencompose.domain.entities.SizeType
import com.coolhabit.textfieldgencompose.domain.entities.TextFieldSettings
import com.coolhabit.textfieldgencompose.domain.entities.URLType
import com.coolhabit.textfieldgencompose.textField.extensions.emptyTextFieldSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TextFieldGenViewModel @Inject constructor(
    private val router: ITextFieldRouter,
    private val storage: ILocalStorage,
) : BaseViewModel() {

    private var _textField: TextFieldSettings? = null
    val textField: TextFieldSettings
        get() = _textField!!

    fun clearOnStart() {
        _textField = emptyTextFieldSettings()
        storage.clearPreferences()
        println(storage.getSettingsList())
    }

    fun init() {
        _textField = emptyTextFieldSettings()
        println(storage.getSettingsList())
    }

    fun setId(text: String) {
        textField.id = text
        println(textField)
    }

    fun setContent(text: String) {
        textField.content = text
        println(textField)
    }

    fun setPlaceholder(text: String) {
        textField.placeholderText = text
        println(textField)
    }

    fun setNextResponder(text: String) {
        textField.nextResponder = text
        println(textField)
    }

    fun setBackgroundColor(colorRgb: ColorRGB) {
        textField.backgroundColor = colorRgb
        println(textField)
    }

    fun setTextColor(colorRgb: ColorRGB) {
        textField.textColor = colorRgb
        println(textField)
    }

    fun setBorderColor(colorRgb: ColorRGB) {
        textField.borderColor = colorRgb
        println(textField)
    }

    fun setPlaceholderTextColor(colorRgb: ColorRGB) {
        textField.placeholderTextColor = colorRgb
        println(textField)
    }

    fun setUnderlineColor(colorRgb: ColorRGB) {
        textField.underlineColor = colorRgb
        println(textField)
    }

    fun setSize(size: SizeType) {
        textField.size = size
        println(textField)
    }

    fun setBottomPadding(int: Int) {
        textField.bottomPadding = int
        println(textField)
    }

    fun setLeftPadding(int: Int) {
        textField.leftPadding = int
        println(textField)
    }

    fun setRightPadding(int: Int) {
        textField.rightPadding = int
        println(textField)
    }

    fun setRimPadding(int: Int) {
        textField.rimPadding = int
        println(textField)
    }

    fun setBorderWidth(int: Int) {
        textField.borderWidth = int
        println(textField)
    }

    fun setFontSize(int: Int) {
        textField.fontSize = int
        println(textField)
    }

    fun setLines(int: Int) {
        textField.lines = int
        println(textField)
    }

    fun setMaxStroke(int: Int) {
        textField.maxStroke = int
        println(textField)
    }

    fun setRadius(int: Int) {
        textField.cornerRadius = int
        println(textField)
    }

    fun setUnderlineThickness(int: Int) {
        textField.underlineThickness = int
        println(textField)
    }

    fun setExecutionDelay(double: Double) {
        textField.executionDelay = double
        println(textField)
    }

    fun setLineSpace(int: Int) {
        textField.lineSpace = int
        println(textField)
    }

    fun setFirstResponder(boolean: Boolean) {
        textField.isFirstResponder = boolean
        println(textField)
    }

    fun setInput(boolean: Boolean) {
        textField.isInput = boolean
        println(textField)
    }

    fun setInputFieldHeightDynamic(boolean: Boolean) {
        textField.isInputFieldHeightDynamic = boolean
        println(textField)
    }

    fun setScrollable(boolean: Boolean) {
        textField.isScrollable = boolean
        println(textField)
    }

    fun setSecureText(boolean: Boolean) {
        textField.isSecureText = boolean
        println(textField)
    }

    fun setShadow(shadow: ShadowType) {
        textField.shadow = shadow
        println(textField)
    }

    fun setAlign(align: String) {
        textField.align = align
        println(textField)
    }

    fun setFont(font: String) {
        textField.font = font
        println(textField)
    }

    fun setKeyboardType(type: String) {
        textField.keyboardType = type
        println(textField)
    }

    fun setPosition(position: PositionXY) {
        textField.position = position
        println(textField)
    }

    fun setUrl(url: URLType) {
        textField.url = url
        println(textField)
    }

    private fun saveElement() {
        val oldList = storage.getSettingsList()?.toMutableList()
        oldList?.add(textField)
        oldList?.let { storage.saveSettingsList(it) }
    }

    fun navigateToSecondTextFieldSettings() {
        storage.saveSettingsList(listOf(textField))
        navigateTo(router.navigateToSecond())
    }

    fun navigateToThirdTextFieldSettings() {
        saveElement()
        navigateTo(router.navigateToThird())
    }

    fun calculateScreen() {
        saveElement()
        navigateTo(router.navigateToFinish())
    }
}
