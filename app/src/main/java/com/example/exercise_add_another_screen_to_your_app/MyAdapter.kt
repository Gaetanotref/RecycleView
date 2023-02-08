package com.example.exercise_add_another_screen_to_your_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val itemList : List<ItemList>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.titolo.text = currentItem.titolo
        holder.image.setImageResource(currentItem.image)
    }
    override fun getItemCount(): Int {
        return itemList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titolo :TextView = itemView.findViewById(R.id.titoloListItem)
    val image : ShapeableImageView = itemView.findViewById(R.id.image_list_item)
    }
}