package com.coolhabit.textfieldgencompose.baseui.model

sealed class StatefulData<T> {

    class Loading<T>() : StatefulData<T>()
    class Success<T>(val value: T) : StatefulData<T>()
    class Error<T>(val throwable: Throwable) : StatefulData<T>()

    val isLoading: Boolean get() = this is Loading

    fun isSuccessful(get: (T) -> Unit) {
        when (this) {
            is Loading -> {
            }
            is Error -> {
            }
            is Success -> get(value)
        }
    }

    fun isLoading(get: () -> Unit) {
        when (this) {
            is Loading -> get()
            is Error -> {
            }
            is Success -> {
            }
        }
    }

    fun isError(get: (String) -> Unit) {
        when (this) {
            is Loading -> {
            }
            is Error -> throwable.message?.let { get(it) }
            is Success -> {
            }
        }
    }
}
