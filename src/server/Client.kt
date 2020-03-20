package server

import java.io.*
import java.net.Socket

class Client(host: String, port: Int) {
    private val PORT = port
    lateinit var clientSocket: Socket
    lateinit var inputReader: BufferedReader
    lateinit var outputWriter: BufferedWriter

    init {
        try {
            println("Attempting to connect to server port $PORT")
            clientSocket = Socket(host, PORT)
            println("Connected to a server: $clientSocket")
            inputReader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
            outputWriter = BufferedWriter(OutputStreamWriter(clientSocket.getOutputStream()))
            println("Server message: ${inputReader.readLine()}")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}