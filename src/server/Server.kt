package server

import java.io.*
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket

class Server(port: Int) {
    private val port = port

    private var serverSocket: ServerSocket = ServerSocket(port);
    private var connectionList: Array<ServerConnection> = emptyArray()

    init {
        println("Starting server $serverSocket ${serverSocket.inetAddress.canonicalHostName}")

        while (true) {
            try {
                var socket = serverSocket.accept()
                println("client connected: $socket")

                var connection = ServerConnection(socket)
                connectionList.plusElement(connection)
                connection.notifyClient("Hello from server!")

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}