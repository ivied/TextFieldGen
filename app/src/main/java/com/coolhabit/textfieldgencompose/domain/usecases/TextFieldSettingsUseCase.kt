package com.coolhabit.textfieldgencompose.domain.usecases

import com.bumptech.glide.load.HttpException
import com.coolhabit.textfieldgencompose.baseui.model.Resource
import com.coolhabit.textfieldgencompose.data.extensions.INTERNET_ERROR
import com.coolhabit.textfieldgencompose.data.extensions.UNEXPECTED_ERROR
import com.coolhabit.textfieldgencompose.domain.api.ILocalStorage
import com.coolhabit.textfieldgencompose.domain.entities.TextFieldSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class TextFieldSettingsUseCase @Inject constructor(
    private val storage: ILocalStorage,
) {

    operator fun invoke(): Flow<Resource<List<TextFieldSettings>?>> = flow {
        try {
            emit(Resource.Loading())
            val list = storage.getSettingsList()

            emit(Resource.Success(list))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: UNEXPECTED_ERROR))
        } catch (e: IOException) {
            emit(Resource.Error(INTERNET_ERROR))
        }
    }
}
