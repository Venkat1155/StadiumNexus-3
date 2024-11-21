package com.venkat.stadiumnexus.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.venkat.stadiumnexus.R
import com.venkat.stadiumnexus.components.ButtonComponent
import com.venkat.stadiumnexus.components.ClickableLoginTextComponent
import com.venkat.stadiumnexus.components.DividerTextComponent
import com.venkat.stadiumnexus.components.HeadingTextComponent
import com.venkat.stadiumnexus.components.MyTextFieldComponent
import com.venkat.stadiumnexus.components.PasswordTextFieldComponent
import com.venkat.stadiumnexus.data.StadiumSigninViewModel
import com.venkat.stadiumnexus.data.StadiumLogin.Stadiumevent
import com.venkat.stadiumnexus.navigation.AppRouter
import com.venkat.stadiumnexus.navigation.Screen
import com.venkat.stadiumnexus.navigation.SystemBackButtonHandler


@Composable
fun LoginScreen(loginViewModel: StadiumSigninViewModel = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {

            Column( modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier.size(350.dp),
                    painter = painterResource(id = R.drawable.st),
                    contentDescription = null)
                Spacer(modifier = Modifier.height(0.dp))
                HeadingTextComponent(value = "Login Page")
                Spacer(modifier = Modifier.height(10.dp))

                MyTextFieldComponent(labelValue = stringResource(id = com.venkat.stadiumnexus.R.string.email),
                    painterResource(id = com.venkat.stadiumnexus.R.drawable.message),
                    onTextChanged = { loginViewModel.onEvent(Stadiumevent.EmailChanged(it)) },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id =com.venkat.stadiumnexus. R.string.password),
                    painterResource(id = com.venkat.stadiumnexus.R.drawable.lock),
                    onTextSelected = {
                        loginViewModel.onEvent(Stadiumevent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(10.dp))

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = com.venkat.stadiumnexus.R.string.login),
                    onButtonClicked = {
                       loginViewModel.onEvent(Stadiumevent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    AppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }

        if(loginViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
    }

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

