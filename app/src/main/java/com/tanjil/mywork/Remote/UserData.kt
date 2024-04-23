package com.tanjil.mywork.Remote


data class User(
    val name: String,
    val profile:String,
    val state: String,
    val district: String,
    val upaZilla: String,
    val union: String?,
    val phoneNumber: String,
    val services: List<String>,
    val latitude: Double,
    val longitude: Double
)
