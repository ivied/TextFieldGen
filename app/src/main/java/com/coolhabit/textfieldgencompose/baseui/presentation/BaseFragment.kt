package com.coolhabit.textfieldgencompose.baseui.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.coolhabit.textfieldgencompose.baseui.model.NavCommand
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment : Fragment() {

    protected val mainActivity: AppCompatActivity?
        get() = activity as? AppCompatActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        withViewModel().apply {
            onNavigationCommands()
        }
    }

    abstract fun withViewModel(): BaseViewModel

    private fun BaseViewModel.onNavigationCommands() {
        this.navigationCommand.collectWithState { action ->
            when (action) {
                is NavCommand.Navigate -> findNavController().navigate(
                    action.directions,
                )
                is NavCommand.Deeplink -> {
                    if (action.backTo > 0) {
                        findNavController().popBackStack(action.backTo, true)
                    }
                    findNavController().navigate(action.deeplinkRequest)
                }
                is NavCommand.Intent -> {
                    try {
                        requireContext().startActivity(action.intent)
                    } catch (ext: Throwable) {
                        // nothing
                    }
                }
                is NavCommand.GoBack -> {
                    action.backTo.takeIf { it > 0 }?.let {
                        val result = !findNavController().popBackStack(it, false)
                        if (result) {
                            forceApplicationFinish()
                        }
                    } ?: kotlin.run {
                        if (!findNavController().popBackStack()) {
                            forceApplicationFinish()
                        }
                    }
                }
            }
        }
    }

    protected fun <T> Flow<T>.collectWithState(getData: (T) -> Unit) {
        val currentFlow = this
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                currentFlow.collect {
                    getData(it)
                }
            }
        }
    }

    private fun forceApplicationFinish() {
        requireActivity().finish()
    }

    fun showToastMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
