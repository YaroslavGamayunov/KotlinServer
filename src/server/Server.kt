package server

import java.io.*
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket

class Server<I, O>(port: Int) : Thread() {
    private val port = port

    private lateinit var serverSocket: ServerSocket
    var connectionList: ArrayList<ServerConnection<I, O>> = ArrayList()


    init {
        try {
            serverSocket = ServerSocket(port);
            println("Starting server $serverSocket ${serverSocket.inetAddress.canonicalHostName}")
            start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun run() {
        while (true) {
            try {
                var socket = serverSocket.accept()
                println("client connected: $socket")

                connectionList.add(ServerConnection<I, O>(socket))

                println("connections list len=${connectionList.size}")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}