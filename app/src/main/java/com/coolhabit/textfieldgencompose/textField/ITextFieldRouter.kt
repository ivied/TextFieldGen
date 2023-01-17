package com.coolhabit.textfieldgencompose.textField

import com.coolhabit.textfieldgencompose.baseui.model.NavCommand

interface ITextFieldRouter {

    fun navigateToSecond(): NavCommand

    fun navigateToThird(): NavCommand

    fun navigateToFinish(): NavCommand

    fun startAgain(): NavCommand
}
