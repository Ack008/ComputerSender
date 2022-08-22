package com.example.computersender

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.Adapter
import android.widget.Button
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
        var Addresses = mutableListOf<String>();
        var Adapter = RecyclerAdapter(Addresses,this)
        View.adapter = Adapter;

        var ScanButton : Button = findViewById(R.id.scanBut);
        ScanButton.setOnClickListener {
            ScanButton.isClickable  = false;
            ScanButton.alpha = 0.5f;
            var portScanner = PortScanner("192.168.1", 0, 255);

            var t1 = Thread {
                var stringa = portScanner.Run().toMutableList();
                Addresses.clear();
                Addresses.addAll(stringa);
                var ui = runOnUiThread {
                    Adapter.notifyItemInserted(Addresses.size);
                }
                ScanButton.isClickable  = true;
                ScanButton.alpha = 1.0f;

            }
            t1.start();
        }




    }
}

