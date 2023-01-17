package com.coolhabit.textfieldgencompose.domain.api

import com.coolhabit.textfieldgencompose.domain.entities.TextFieldSettings

interface ILocalStorage {

    fun getSettingsList(): List<TextFieldSettings>?

    fun saveSettingsList(list: List<TextFieldSettings>)

    fun clearPreferences(): Boolean
}
