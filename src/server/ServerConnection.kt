package server

import java.io.*
import java.net.Socket

class ServerConnection<I, O>(socket: Socket) : Thread() {
    private var client = socket

    private lateinit var clientInput: ObjectInputStream
    private lateinit var clientOutput: ObjectOutputStream

    init {
        try {
            clientOutput = ObjectOutputStream(client.getOutputStream())
            clientInput = ObjectInputStream(client.getInputStream())
            start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun notifyClient(serverObject: O) {
        println("writing obj $serverObject")
        clientOutput.writeObject(serverObject)
        clientOutput.flush()
    }

    override fun run() {
        while (true) {
            try {
                sleep(1000)
                var inputObject: I = clientInput.readObject() as I
                println("Object from client received: $inputObject socket=$client ")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

}