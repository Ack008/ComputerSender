package com.example.computersender

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.Adapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.net.InetSocketAddress
import java.net.Socket
import java.sql.Array

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var View = findViewById<RecyclerView>(R.id.view);
        View.layoutManager = LinearLayoutManager(this);
        var Addresses = arrayOf("192.168.1.192", "192.168.1.242");
        var Adapter = RecyclerAdapter(Addresses.toMutableList())
        View.adapter = Adapter;

    }
}

