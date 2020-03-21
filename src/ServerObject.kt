import java.io.Serializable

enum class PacketType {
    CONNECTION_DATA, MESSAGE, IMAGE
}

class ServerObject(type: PacketType, obj: Any) : Serializable {
    val type = type
    var obj = obj
}