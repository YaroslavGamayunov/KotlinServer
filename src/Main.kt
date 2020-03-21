import server.ServerConnection
import java.net.Socket

fun main(args: Array<String>) {
    var client = ServerConnection(Socket("192.168.0.105", 4004))
    while (true) {
        var line = readLine()
        client.sendData(ServerObject(PacketType.MESSAGE, line as String))
    }
}