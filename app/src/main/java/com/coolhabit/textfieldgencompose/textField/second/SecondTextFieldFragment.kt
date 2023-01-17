package com.coolhabit.textfieldgencompose.textField.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.coolhabit.textfieldgencompose.baseui.presentation.BaseFragment
import com.coolhabit.textfieldgencompose.baseui.presentation.BaseViewModel
import com.coolhabit.textfieldgencompose.baseui.ui.theme.TextFieldGenComposeTheme
import com.coolhabit.textfieldgencompose.textField.TextFieldGenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondTextFieldFragment : BaseFragment() {

    private val viewModel: TextFieldGenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ComposeView(requireContext())
        view.setContent {
            TextFieldGenComposeTheme() {
                SecondTextFieldScreen(
                    viewModel = viewModel,
                )
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun withViewModel(): BaseViewModel = viewModel.apply {
    }
}
