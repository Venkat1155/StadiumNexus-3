package  com.venkat.stadiumnexus.data.StadiumRegister

sealed class StadiumRegisterEvent{

    data class FirstNameChanged(val firstName:String) : StadiumRegisterEvent()
    data class LastNameChanged(val lastName:String) : StadiumRegisterEvent()
    data class EmailChanged(val email:String): StadiumRegisterEvent()
    data class PasswordChanged(val password: String) : StadiumRegisterEvent()

    data class PrivacyPolicyCheckBoxClicked(val status:Boolean) : StadiumRegisterEvent()

    object RegisterButtonClicked : StadiumRegisterEvent()
}
