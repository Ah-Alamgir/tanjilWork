package com.tanjil.mywork.Remote

data class UserDAO(
    var name:String = "Md abu hanif",
    var ID:String = "",
    var ismale:Boolean = true,
    var phoneNumber:String = "+8801872478757",
    var longitute:String = "",
    var lactitute:String = "",
    var profession:List<String> = arrayListOf("farmer", "banker", "fucker")
)