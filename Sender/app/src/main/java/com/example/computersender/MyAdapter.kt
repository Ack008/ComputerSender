package com.example.computersender

import android.location.Address
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(Address_ : MutableList<String>) : RecyclerView.Adapter<RecyclerAdapter.myViewHolder>(){
    var Address = Address_;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.myViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.views, parent, false);
        return myViewHolder(View);
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.myViewHolder, position: Int) {
        holder.testo.text = Address[position];
    }

    override fun getItemCount(): Int {
        return Address.size;
    }


    class myViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var testo : TextView;
        init {
            testo = itemView.findViewById(R.id.textView3);

        }

    }
}