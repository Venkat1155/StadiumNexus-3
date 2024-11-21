package com.venkat.stadiumnexus.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venkat.stadiumnexus.data.StadiumHome.HomeViewModel
import com.venkat.stadiumnexus.navigation.AppRouter
import com.venkat.stadiumnexus.navigation.Screen
import com.venkat.stadiumnexus.screens.HomeScreen
import com.venkat.stadiumnexus.screens.LoginScreen
import com.venkat.stadiumnexus.screens.SignUpScreen
import com.venkat.stadiumnexus.screens.TermsAndConditionsScreen


@Composable
fun StadiumNexus(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            AppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = AppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }

    }
}