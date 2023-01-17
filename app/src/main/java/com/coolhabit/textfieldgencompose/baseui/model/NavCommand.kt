package com.coolhabit.textfieldgencompose.baseui.model

import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections

sealed class NavCommand {
    class Navigate(val directions: NavDirections) : NavCommand()

    class Deeplink(val deeplinkRequest: NavDeepLinkRequest, val backTo: Int = -1) : NavCommand()

    class Intent(val intent: android.content.Intent) : NavCommand()

    class GoBack(val backTo: Int = -1) : NavCommand()
}
