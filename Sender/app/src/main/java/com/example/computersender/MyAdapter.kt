package com.example.computersender

import android.app.Activity
import android.location.Address
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.net.Socket
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.RecyclerView
import java.io.DataOutputStream
import java.net.InetSocketAddress

class RecyclerAdapter(Address_ : MutableList<String>, Attivita_ : AppCompatActivity) : RecyclerView.Adapter<RecyclerAdapter.myViewHolder>(){
    var Address = Address_;
    var Attivita = Attivita_;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.myViewHolder {
        var View = LayoutInflater.from(parent.context).inflate(R.layout.views, parent, false);
        return myViewHolder(View);
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.myViewHolder, position: Int) {
        holder.testo.text = Address[position];
        holder.Immagine.setBackgroundResource(R.drawable.ic_launcher_background);
        holder.Immagine.setImageResource(R.drawable.ic_launcher_foreground);
        holder.testo.setOnClickListener{
            var t1 = Thread {
                try{
                val socket = Socket();
                socket.connect(InetSocketAddress(Address[position],9999),100)
                var dos = DataOutputStream(socket.getOutputStream());
                dos.writeUTF("msg");
                dos.close();
                socket.close();
                } catch (e: java.net.SocketTimeoutException){
                    println("Non più esistente\n")
                }
                finally {
                    Address.removeAt(position);
                    Attivita.runOnUiThread {
                        notifyItemRemoved(position);
                    }
                }
            }
            t1.start();


        }

    }

    override fun getItemCount(): Int {
        return Address.size;
    }


    class myViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var testo : TextView;
        var Immagine : ImageView;
        init {
            testo = itemView.findViewById(R.id.textView2);
            Immagine = itemView.findViewById(R.id.imageView2)

        }

    }
}