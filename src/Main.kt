import server.Client
import server.Server
import java.lang.Thread.sleep

fun main(args: Array<String>) {
    Thread {
        var server = Server(4004)
    }.start();
    Thread {
        sleep(2000)
        var client = Client("localhost", 4004)
    }.start();
}