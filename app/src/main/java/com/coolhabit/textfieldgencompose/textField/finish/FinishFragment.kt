package com.coolhabit.textfieldgencompose.textField.finish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.coolhabit.textfieldgencompose.baseui.presentation.BaseFragment
import com.coolhabit.textfieldgencompose.baseui.presentation.BaseViewModel
import com.coolhabit.textfieldgencompose.baseui.ui.theme.TextFieldGenComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FinishFragment : BaseFragment() {

    private val viewModel: FinishViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ComposeView(requireContext())
        view.setContent {
            TextFieldGenComposeTheme() {
                FinishScreen(
                    viewModel = viewModel,
                    showLink = {
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    }
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
