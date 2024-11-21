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
import com.venkat.stadiumnexus.components.ButtonComponent
import com.venkat.stadiumnexus.components.CheckboxComponent
import com.venkat.stadiumnexus.components.ClickableLoginTextComponent
import com.venkat.stadiumnexus.components.DividerTextComponent
import com.venkat.stadiumnexus.components.HeadingTextComponent
import com.venkat.stadiumnexus.components.MyTextFieldComponent
import com.venkat.stadiumnexus.components.PasswordTextFieldComponent
import com.venkat.stadiumnexus.data.StadiumRegister.StadiumRegisterEvent
import com.venkat.stadiumnexus.data.StadiumRegister.StadiumViewModel
import com.venkat.stadiumnexus.navigation.AppRouter
import com.venkat.stadiumnexus.navigation.Screen


@Composable
fun SignUpScreen(signupViewModel: StadiumViewModel = viewModel()) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center,

    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center)
            {
                Image(
                    modifier = Modifier.size(280.dp),
                    painter = painterResource(id = com.venkat.stadiumnexus.R.drawable.st),
                    contentDescription = null)
                  HeadingTextComponent(value = "Stadium Nexus App")
                  Spacer(modifier = Modifier.height(1.dp))
                  MyTextFieldComponent(
                    labelValue = stringResource(id = com.venkat.stadiumnexus.R.string.first_name),
                    painterResource(id =com.venkat.stadiumnexus. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(StadiumRegisterEvent.FirstNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.firstNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id = com.venkat.stadiumnexus.R.string.last_name),
                    painterResource = painterResource(id =com.venkat.stadiumnexus. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(StadiumRegisterEvent.LastNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.lastNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id =com.venkat.stadiumnexus. R.string.email),
                    painterResource = painterResource(id = com.venkat.stadiumnexus.R.drawable.message),
                    onTextChanged = {
                        signupViewModel.onEvent(StadiumRegisterEvent.EmailChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = com.venkat.stadiumnexus.R.string.password),
                    painterResource = painterResource(id = com.venkat.stadiumnexus.R.drawable.ic_lock),
                    onTextSelected = {
                        signupViewModel.onEvent(StadiumRegisterEvent.PasswordChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.passwordError
                )

                CheckboxComponent(value = stringResource(id = com.venkat.stadiumnexus.R.string.terms_and_conditions),
                    onTextSelected = {
                        AppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                        signupViewModel.onEvent(StadiumRegisterEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ButtonComponent(
                    value = stringResource(id =com.venkat.stadiumnexus. R.string.register),
                    onButtonClicked = {
                        signupViewModel.onEvent(StadiumRegisterEvent.RegisterButtonClicked)
                    },
                    isEnabled = signupViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(10.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    AppRouter.navigateTo(Screen.LoginScreen)
                })
            }
        }


        if(signupViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }

}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}