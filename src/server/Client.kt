package server

import java.io.IOException
import java.net.Socket

class Client(port: Int) {
    val port = port
    lateinit var clientSocket: Socket

    init {
        try {
            println("Attempting to connect to server port $port")
            clientSocket = Socket("localhost", port)
            println("Connecting to server...")
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}