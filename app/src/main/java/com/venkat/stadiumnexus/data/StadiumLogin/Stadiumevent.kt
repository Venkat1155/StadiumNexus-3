package com.venkat.stadiumnexus.data.StadiumLogin

sealed class Stadiumevent{

    data class EmailChanged(val email:String): Stadiumevent()
    data class PasswordChanged(val password: String) : Stadiumevent()

    object LoginButtonClicked : Stadiumevent()
}
