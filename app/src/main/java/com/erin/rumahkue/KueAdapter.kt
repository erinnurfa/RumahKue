package com.erin.rumahkue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KueAdapter(private val context: Context, private val kue: List<Kue>, val listener: (Kue) -> Unit)
    : RecyclerView.Adapter<KueAdapter.KueViewHolder>(){

    class KueViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imgKue = view.findViewById<ImageView>(R.id.img_item_photo)
        val nameKue = view.findViewById<TextView>(R.id.tv_item_name)
        val descKue = view.findViewById<TextView>(R.id.tv_item_description)

        fun bindView(kue: Kue, listener: (Kue) -> Unit){
            imgKue.setImageResource(kue.imgKue)
            nameKue.text = kue.nameKue
            descKue.text = kue.descKue
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KueViewHolder {
        return KueViewHolder(LayoutInflater.from(context).inflate(R.layout.item_kue, parent, false))
    }

    override fun onBindViewHolder(holder: KueViewHolder, position: Int) {
        holder.bindView(kue[position], listener)
    }

    override fun getItemCount(): Int = kue.size

}