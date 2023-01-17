package com.coolhabit.textfieldgencompose.app.navigation

import com.coolhabit.textfieldgencompose.baseui.model.NavCommand
import com.coolhabit.textfieldgencompose.textField.ITextFieldRouter
import com.coolhabit.textfieldgencompose.textField.finish.FinishFragmentDirections
import com.coolhabit.textfieldgencompose.textField.first.FirstTextFieldFragmentDirections
import com.coolhabit.textfieldgencompose.textField.second.SecondTextFieldFragmentDirections
import com.coolhabit.textfieldgencompose.textField.third.ThirdTextFieldFragmentDirections

class TextFieldRouterImpl : ITextFieldRouter {
    override fun navigateToSecond(): NavCommand {
        return NavCommand.Navigate(FirstTextFieldFragmentDirections.openSecond())
    }

    override fun navigateToThird(): NavCommand {
        return NavCommand.Navigate(SecondTextFieldFragmentDirections.openThird())
    }

    override fun navigateToFinish(): NavCommand {
        return NavCommand.Navigate(ThirdTextFieldFragmentDirections.calculateFinish())
    }

    override fun startAgain(): NavCommand {
        return NavCommand.Navigate(FinishFragmentDirections.startAgain())
    }
}
