package server

import ServerObject

interface SocketConnectionCallback {
    fun onReceive(serverObject: ServerObject)
}