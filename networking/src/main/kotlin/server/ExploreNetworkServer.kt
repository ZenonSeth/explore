package server

import com.esotericsoftware.kryonet.Connection
import com.esotericsoftware.kryonet.Listener
import com.esotericsoftware.kryonet.Server
import common.Networking
import common.login.LoginRequest
import common.login.LoginResponse
import java.util.*


/**
 * Written by Milcho on 5/21/2019.
 */
class ExploreNetworkServer {

    lateinit var server: Server
    var connectionCounter: Long = 0

    var loggedIn: HashSet<String> = HashSet()

    fun start(port: Int = Networking.DEFAULT_PORT) {

        server = object : Server() {
            override fun newConnection(): Connection {
                println("New connection established number = $connectionCounter")
                val connection = UserConnection(connectionCounter.toString(16))
                connectionCounter++
                return connection
            }
        }

        Networking.register(server)

        com.esotericsoftware.minlog.Log.set(com.esotericsoftware.minlog.Log.LEVEL_DEBUG)

        server.addListener(object : Listener() {
            override fun connected(var1: Connection) {

            }

            override fun disconnected(var1: Connection) {

            }

            override fun received(connection: Connection, request: Any) {
                println("Server got request: $request")
                if (request is LoginRequest) {
                    if (request.username.equals("milcho", true)
                            && request.password.equals("hash", true)) {
                        connection.sendUDP(LoginResponse(true))
                    } else {
                        connection.sendUDP(LoginResponse(false))
                    }
                }
            }

            override fun idle(var1: Connection) {

            }
        })

        server.start()
        server.bind(port, port + 1)
        println("server start successful")
    }

    fun stop() {
        server.stop()
    }
}