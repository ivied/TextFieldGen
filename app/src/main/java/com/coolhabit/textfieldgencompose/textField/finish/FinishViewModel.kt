package com.coolhabit.textfieldgencompose.textField.finish

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.coolhabit.textfieldgencompose.baseui.model.Resource
import com.coolhabit.textfieldgencompose.baseui.presentation.BaseViewModel
import com.coolhabit.textfieldgencompose.data.extensions.UNEXPECTED_ERROR
import com.coolhabit.textfieldgencompose.domain.usecases.TextFieldSettingsUseCase
import com.coolhabit.textfieldgencompose.textField.ITextFieldRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FinishViewModel @Inject constructor(
    private val useCase: TextFieldSettingsUseCase,
    private val router: ITextFieldRouter,
) : BaseViewModel() {

    private val _state = mutableStateOf(TextFieldState())
    val state: State<TextFieldState> = _state

    init {
        getSettings()
    }

    fun getSettings() {
        useCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TextFieldState(settings = result.data?.toMutableList() ?: mutableListOf())
                }
                is Resource.Error -> {
                    _state.value = TextFieldState(error = result.message ?: UNEXPECTED_ERROR)
                }
                is Resource.Loading -> {
                    _state.value = TextFieldState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun startAgain() {
        navigateTo(router.startAgain())
    }
}
