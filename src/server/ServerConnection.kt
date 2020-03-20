package server

import java.io.*
import java.net.Socket
import java.util.*

class ServerConnection(socket: Socket) : Thread() {
    private var client = socket
    private var inputStream: BufferedReader
    private var outputStream: BufferedWriter

    init {
        inputStream = BufferedReader(InputStreamReader(client.getInputStream()))
        outputStream = BufferedWriter(OutputStreamWriter(client.getOutputStream()))
        start()
    }

    fun notifyClient(message: String) {
        outputStream.write(message + "\n")
        outputStream.flush()
    }

    override fun run() {
        while (true) {
            try {
                var line = inputStream.readLine()
                println("Message received: '$line' socket=$client ")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}