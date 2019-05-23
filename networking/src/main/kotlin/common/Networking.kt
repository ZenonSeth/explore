package common

import com.esotericsoftware.kryonet.EndPoint
import common.login.LoginRequest
import common.login.LoginResponse

/**
 * Written by Milcho on 5/22/2019.
 */
object Networking {
    const val DEFAULT_PORT = 47525

    // This registers objects that are going to be sent over the network.
    fun register(endPoint: EndPoint) {
        val kryo = endPoint.kryo
        kryo.register(LoginRequest::class.java)
        kryo.register(LoginResponse::class.java)
    }
}
