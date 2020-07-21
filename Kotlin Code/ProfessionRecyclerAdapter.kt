package com.bhartendra.partnerapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bhartendra.partnerapp.Model.Profession
import com.bhartendra.partnerapp.R
import kotlinx.android.synthetic.main.recycler_profession_single_row.view.*

class ProfessionRecyclerAdapter(val context : Context, val profession : ArrayList<Profession>, val listener: OnItemClickListener): RecyclerView.Adapter<ProfessionRecyclerAdapter.ProfessionViewHolder>() {

    class ProfessionViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgProfession: ImageView = view.findViewById(R.id.imgProfession)
        val txtProfession: TextView = view.findViewById(R.id.txtProfession)
        val cbProfession: CheckBox = view.findViewById(R.id.cbProfession)
        val llProfession: LinearLayout = view.findViewById(R.id.llProfession)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_profession_single_row, parent, false)

        return ProfessionViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return profession.size
    }
    interface OnItemClickListener {
        fun onProfessionClick()
    }

    override fun onBindViewHolder(holder: ProfessionViewHolder, position: Int) {
        val profession = profession[position]
        holder.imgProfession.setImageResource(profession.image)
        holder.txtProfession.text = profession.profession
        holder.cbProfession.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                listener.onProfessionClick()
                val color = ContextCompat.getColor(context, R.color.colorPrimaryDark)
                holder.llProfession.setBackgroundColor(color)
            }
            else {
                val colorWhite = ContextCompat.getColor(context, R.color.white)
                holder.llProfession.setBackgroundColor(colorWhite)
            }
        }
    }
}