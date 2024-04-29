package com.tanjil.mywork.Remote

data class UserDAO(
    var name:String = "",
    var ID:String = "",
    var phoneNumber:String = "",
    var division:String = "",
    var district:String = "",
    var policeStation:String = "",
    var longitute:String = "",
    var lactitute:String = "",
    var profession:List<String> = emptyList()
){
    companion object{
        lateinit var userDivision:String
        lateinit var userDistrict:String
        lateinit var userPoliceStation:String


        val userDao = UserDAO()
    }
}