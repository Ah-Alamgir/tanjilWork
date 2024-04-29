package com.hanif.mywork.Remote

import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.FirebaseDatabase
import com.tanjil.mywork.Remote.UserDAO.Companion.userDao
import com.tanjil.mywork.Remote.UserDAO.Companion.userDistrict
import com.tanjil.mywork.Remote.UserDAO.Companion.userDivision
import com.tanjil.mywork.Remote.UserDAO.Companion.userPoliceStation

class getFirebaseData {

    fun getData() {

    }

    fun storeData() {
        val db = FirebaseDatabase.getInstance().getReference("UserList")
        db.child(userDivision).child(userDistrict).child(userPoliceStation)
            .child(userDao.profession[0]).setValue(userDao).addOnSuccessListener {

        }
    }
}