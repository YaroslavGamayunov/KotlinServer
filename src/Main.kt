import server.Connection
import server.Server
import server.SocketConnectionCallback
import java.lang.Thread.sleep
import java.net.Socket

fun main(args: Array<String>) {
    var server = Server(4004)
    Thread {
        var client = Connection(Socket("localhost", 4004))
        client.connectionCallback = object : SocketConnectionCallback {
            override fun onReceive(serverObject: ServerObject) {
                println("Client received object $serverObject")
            }
        }
        client.sendData(ServerObject(PacketType.MESSAGE, "hi from client!"))
        //client.notifyServer(ServerObject(PacketType.MESSAGE, "hi from client!"))
    }.start();

    Thread {
        sleep(5000)
        for (connection in server.connectionList) {
            connection.sendData(ServerObject(PacketType.MESSAGE, "hi from server!"))
        }

    }.start()
}