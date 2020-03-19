import server.Client
import server.Server

fun main(args: Array<String>) {
    var thread = Thread {
        var server = Server()
    }.start();
    var client = Client(4004)
}