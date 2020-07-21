package com.bhartendra.partnerapp.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.bhartendra.partnerapp.R

class OtpActivity : AppCompatActivity() {

    lateinit var txtNumber: TextView
    lateinit var pinView: EditText
    lateinit var txtResendOtp: TextView
    lateinit var btnOtpBack: ImageButton
    lateinit var btnOtpVerify: Button
    lateinit var btnOtpVerifyBlur: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        txtNumber= findViewById(R.id.txtNumber)
        pinView = findViewById(R.id.pinView)
        txtResendOtp = findViewById(R.id.txtResendOtp)
        btnOtpBack = findViewById(R.id.btnOtpBack)
        btnOtpVerify = findViewById(R.id.btnOtpVerify)
        btnOtpVerifyBlur = findViewById(R.id.btnOtpVerifyBlur)

        btnOtpBack.setOnClickListener {
            onBackPressed()
        }
        txtResendOtp.setOnClickListener {
            Toast.makeText(this@OtpActivity,"OTP resent successfully.",Toast.LENGTH_SHORT).show()
        }
        val number = intent.getStringExtra("number")
        txtNumber.text = "Enter OTP sent to +91 $number"

        pinView.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val otp = s.toString()
                if (otp.length == 4){
                    btnOtpVerify.visibility = View.VISIBLE
                    btnOtpVerifyBlur.visibility = View.GONE
                }
                else{
                    btnOtpVerify.visibility = View.GONE
                    btnOtpVerifyBlur.visibility = View.VISIBLE
                }
            }

        })
        btnOtpVerify.setOnClickListener {
            val intent = Intent(this@OtpActivity,
                ProfessionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}