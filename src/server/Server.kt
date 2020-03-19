package server

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.net.ServerSocket
import java.net.Socket

class Server {
    //lateinit var clientSocket: Socket; //сокет для общения
    lateinit var serverSocket: ServerSocket; // серверсокет
    //lateinit var inputStream: BufferedReader; // поток чтения из сокета
    //lateinit var outputStream: BufferedWriter; // поток записи в сокет
    private val PORT = 4004;

    init {
        try {
            println("Starting server port $PORT")
            serverSocket = ServerSocket(PORT)
            var client: Socket = serverSocket.accept()
            println("client connected: $client")
        } catch (e: IOException) {
            e.printStackTrace();
        }
    }
}