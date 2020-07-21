package com.bhartendra.partnerapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhartendra.partnerapp.Adapter.ProfessionRecyclerAdapter
import com.bhartendra.partnerapp.Model.Profession
import com.bhartendra.partnerapp.R

class ProfessionActivity : AppCompatActivity() {

    lateinit var etProfession: EditText
    lateinit var btnProfessionBack: ImageButton
    lateinit var btnProfessionSelect: Button
    lateinit var recyclerProfession: RecyclerView
    lateinit var recyclerAdapter: ProfessionRecyclerAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager

    val listOfProfessions = arrayListOf<Profession>(
        Profession(R.drawable.cleaning,"Cleaning Services"),
        Profession(R.drawable.repair,"Appliance Repair"),
        Profession(R.drawable.pest,"Pest Control"),
        Profession(R.drawable.electrician,"Electrician"),
        Profession(R.drawable.carpenter,"Carpenter"),
        Profession(R.drawable.plumber,"Plumber"),
        Profession(R.drawable.ac,"AC Services & Repair"),
        Profession(R.drawable.salon,"Salon Service"),
        Profession(R.drawable.makeup,"Makeup Artist")
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profession)

        etProfession = findViewById(R.id.etProfession)
        btnProfessionBack = findViewById(R.id.btnProfessionBack)
        btnProfessionSelect = findViewById(R.id.btnProfessionSelect)
        recyclerProfession = findViewById(R.id.recyclerProfession)

        btnProfessionBack.setOnClickListener {
            onBackPressed()
        }
        layoutManager = LinearLayoutManager(this@ProfessionActivity)
        recyclerAdapter = ProfessionRecyclerAdapter(this@ProfessionActivity,listOfProfessions,

            object: ProfessionRecyclerAdapter.OnItemClickListener{
                override fun onProfessionClick() {
                    btnProfessionSelect.visibility = View.VISIBLE
                }

            })
        recyclerProfession.layoutManager = layoutManager
        recyclerProfession.adapter = recyclerAdapter
    }
}