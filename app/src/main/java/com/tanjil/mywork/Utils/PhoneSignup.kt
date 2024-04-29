package com.tanjil.mywork.Utils

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.lang.Thread.State
import java.util.concurrent.TimeUnit


class PhoneSignup : ViewModel() {

    val auth = Firebase.auth
    lateinit var activity: Activity
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    lateinit var credential: PhoneAuthCredential
    lateinit var phoneNumber: String


    fun startPhoneNumberVerification(): Flow<Result<String>> = callbackFlow {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(activity) // Activity (for callback binding)
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    credential = p0
                    trySend(
                        Result.success("Signed")
                    )
                }

                override fun onVerificationFailed(p0: FirebaseException) {
                    trySend(
                        Result.failure(Exception("নাম্ভার টি সঠিক নয়"))
                    )
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {
                    super.onCodeSent(verificationId, token)
                    storedVerificationId = verificationId
                    resendToken = token
                    trySend(
                        Result.success(verificationId)
                    )
                }


            }) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        awaitClose {
            close()
        }
    }

//
//    fun resendVerificationCode(): Flow<Result<String>> = callbackFlow {
//        val optionsBuilder = PhoneAuthOptions.newBuilder(auth)
//            .setPhoneNumber(phoneNumber) // Phone number to verify
//            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//            .setActivity(activity) // (optional) Activity for callback binding
//            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
//                    credential = p0
//                    trySend(
//                        Result.success("Signed")
//                    )
//                }
//
//                override fun onVerificationFailed(p0: FirebaseException) {
//                    trySend(
//                        Result.failure(Exception("নাম্ভার টি সঠিক নয়"))
//                    )
//                }
//
//                override fun onCodeSent(
//                    verificationId: String,
//                    token: PhoneAuthProvider.ForceResendingToken
//                ) {
//                    super.onCodeSent(verificationId, token)
//                    storedVerificationId = verificationId
//                    resendToken = token
//                    trySend(
//                        Result.success(verificationId)
//                    )
//                }
//
//            })
//        if (resendToken != null) {
//            optionsBuilder.setForceResendingToken(resendToken) // callback's ForceResendingToken
//        }
//        PhoneAuthProvider.verifyPhoneNumber(optionsBuilder.build())
//
//        awaitClose {
//            close()
//        }
//    }


    fun signInWithPhoneAuthCredential(code: String): Flow<Result<String>> = callbackFlow {

        val credentials = PhoneAuthProvider.getCredential(storedVerificationId, code)
        auth.signInWithCredential(credentials)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    trySend(
                        Result.success("Signed")
                    )
                    Log.d("luckey", "success")
                } else {
                    trySend(
                        Result.failure(Exception("not Signed"))

                    )
                    Log.d("luckey", task.exception.toString())

                    // Update UI
                }
            }
//
        awaitClose {
            close()
        }
    }

}



