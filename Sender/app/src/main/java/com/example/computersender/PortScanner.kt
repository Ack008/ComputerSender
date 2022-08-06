package com.example.computersender
import java.net.InetSocketAddress
import java.net.Socket
class PortScanner (_ip : String, n1 : Int = 0, n2 : Int =255) {
    var Ip : String = _ip;
    var begin : Int = n1;
    var end : Int = n2;
    var Compatible = mutableListOf<String>();
    fun Run () : List<String>{
        for( i in begin..end){
            try{
                var socket = Socket();
                socket.connect(InetSocketAddress("192.168.1.$i",9999),10)
                socket.close();
                Compatible.add("192.168.1.$i");
            } catch(e : Exception){
                //println("ho il cazzo duro");
                continue;
            }
        }
        return Compatible.toList();

    }
}

fun main(){
    var portScanner = PortScanner("192.168.1", 0, 255);
    var t1 = Thread{
        var stringa = portScanner.Run();
        println(stringa);
    }
    t1.start();
    t1.join();

}