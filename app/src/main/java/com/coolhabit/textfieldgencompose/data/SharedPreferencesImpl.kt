package com.coolhabit.textfieldgencompose.data

import android.content.Context
import android.content.SharedPreferences
import com.coolhabit.textfieldgencompose.domain.api.ILocalStorage
import com.coolhabit.textfieldgencompose.domain.entities.TextFieldSettings
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import javax.inject.Inject

class SharedPreferencesImpl @Inject constructor(private val context: Context) : ILocalStorage {

    companion object {
        const val SHARED_PREF_NAME = "shared_pref_name"
        const val KEY_TEXT_SETTINGS = "key_text_settings"
    }

    private val sharedPref: SharedPreferences by lazy {
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun getSettingsList(): List<TextFieldSettings>? {
        val list = sharedPref.getString(KEY_TEXT_SETTINGS, null)
        val type: Type = object : TypeToken<List<TextFieldSettings?>?>() {}.type
        return Gson().fromJson(list, type)
    }

    override fun saveSettingsList(list: List<TextFieldSettings>) {
        val convertedList = Gson().toJson(list)
        sharedPref
            .edit()
            .putString(KEY_TEXT_SETTINGS, convertedList)
            .apply()
    }

    override fun clearPreferences(): Boolean {
        return sharedPref.edit().clear().commit()
    }
}
