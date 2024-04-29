package com.hanif.mywork.Remote

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase
import com.tanjil.mywork.Remote.UserDAO
import com.tanjil.mywork.Utils.PhoneSignup

class getFirebaseData : ViewModel() {
    companion object {


        lateinit var userDivision: String
        lateinit var userDistrict: String
        lateinit var userPoliceStation: String
        val phoneAuth = PhoneSignup()


        val userDao = UserDAO()

        fun getData(profession:String):ArrayList<UserDAO> {
            val userList = ArrayList<UserDAO>()
            val db = FirebaseDatabase.getInstance().getReference("UserList")
            db.child(userDivision).child(userDistrict).child(userPoliceStation).orderByChild(profession).get()
                .addOnSuccessListener {
                    it.children.forEach {
                        var user: UserDAO? = it.getValue(UserDAO::class.java)
                        if (user?.profession?.contains(profession) == true){
                            userList.add(user)
                        }
                    }
                }
            return userList
        }

        fun storeData() {
            val db = FirebaseDatabase.getInstance().getReference("UserList")
            db.child(userDivision).child(userDistrict).child(userPoliceStation)
                .child(userDao.profession[0]).setValue(userDao).addOnSuccessListener {
                }
        }


        fun saveUserINfo(){

        }


        fun getUserInfo(){

        }
    }
}