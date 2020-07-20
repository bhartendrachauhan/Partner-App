package com.bhartendra.partnerapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var etPhone: EditText
    lateinit var btnBack: ImageButton
    lateinit var btnEnter: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPhone = findViewById(R.id.etPhone)
        btnBack = findViewById(R.id.btnBack)
        btnEnter = findViewById(R.id.btnEnter)

        etPhone.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().trim().isNotEmpty()){
                    btnBack.visibility = View.VISIBLE
                    btnEnter.visibility = View.VISIBLE
                }
                else{
                    btnBack.visibility = View.GONE
                    btnEnter.visibility = View.GONE
                }
            }
        })
        btnBack.setOnClickListener {
            etPhone.text.clear()
        }
        btnEnter.setOnClickListener {
            val number = etPhone.text.toString()
            val intent = Intent(this@MainActivity,OtpActivity::class.java)
            intent.putExtra("number",number)
            startActivity(intent)
        }
    }
}
