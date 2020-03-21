package server

import ServerObject
import java.io.*
import java.net.ServerSocket

class Server(private val port: Int) : Thread() {

    private lateinit var serverSocket: ServerSocket
    var connectionList: ArrayList<ServerConnection> = ArrayList()


    init {
        try {
            serverSocket = ServerSocket(port);
            start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun run() {
        while (true) {
            try {
                var socket = serverSocket.accept()
                var connection = ServerConnection(socket)
                connection.connectionCallback = object : SocketConnectionCallback {
                    override fun onReceive(serverObject: ServerObject) {
                        println("Server received object $serverObject")
                    }
                }
                connectionList.add(connection)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}