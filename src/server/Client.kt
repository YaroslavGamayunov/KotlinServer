package server

import ServerObject
import java.io.*
import java.net.Socket

class Client<I, O>(host: String, port: Int) : Thread() {
    private val port = port

    private var clientSocket = Socket(host, port)
    lateinit var serverInput: ObjectInputStream
    lateinit var serverOutput: ObjectOutputStream

    init {
        try {
            println("Attempting to connect to server port $port")
            println("Connected to a server: $clientSocket")
            serverOutput = ObjectOutputStream(clientSocket.getOutputStream())
            serverInput = ObjectInputStream(clientSocket.getInputStream())
            start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun start() {
        while (true) {
            try {
                sleep(1000)
                println("checking server output: avaiilable=${serverInput.available()}")

                var inputObject: I = serverInput.readObject() as I
                if (inputObject != null) {
                    println("Object from server received: $inputObject")
                }
                println((inputObject as ServerObject).obj as String)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}