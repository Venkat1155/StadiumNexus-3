package com.venkat.stadiumnexus.data

data class StadiumState(
    var email  :String = "",
    var password  :String = "",

    var emailError :Boolean = false,
    var passwordError : Boolean = false

)
