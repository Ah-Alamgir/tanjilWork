package com.tanjil.mywork.Utils

sealed class Screen(val rout:String) {
    object HomeScene: Screen("home")
}