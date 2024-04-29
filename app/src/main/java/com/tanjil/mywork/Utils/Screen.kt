package com.tanjil.mywork.Utils

sealed class Screen(val rout:String) {
    object HomeScene: Screen("home")
    object SelecAddress: Screen("pickAddress")
    object SelectService: Screen("pickService")
    object SIgnUp: Screen("signup")
    object otpScene: Screen("otpScene")
    object ProfileScene: Screen("profile")
    object SearchResult: Screen("SearchResult")

}