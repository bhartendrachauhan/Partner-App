package com.bhartendra.partnerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class OtpActivity : AppCompatActivity() {

    lateinit var txtOtp: TextView
    lateinit var etPinView: EditText
    lateinit var btnResendOtp: Button
    lateinit var btnOtpBack: Button
    lateinit var btnOtpVerify: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

    }
}