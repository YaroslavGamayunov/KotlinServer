import server.Client
import server.Server
import java.lang.Thread.sleep

fun main(args: Array<String>) {
    var server = Server<ServerObject, ServerObject>(4004)

    Thread {
        var client = Client<ServerObject, ServerObject>("localhost", 4004)
        sleep(2000)
    }.start();

    Thread {
        sleep(3000)
        for (connection in server.connectionList) {
            println("notifying!!")
            connection.notifyClient(ServerObject(PacketType.MESSAGE, "hi server"))
        }
    }.start()
}