package client

import com.esotericsoftware.kryonet.Client
import com.esotericsoftware.kryonet.Connection
import com.esotericsoftware.kryonet.Listener
import com.esotericsoftware.kryonet.Listener.ThreadedListener
import common.Networking
import common.login.LoginRequest
import common.login.LoginResponse
import java.io.IOException


/**
 * Written by Milcho on 5/21/2019.
 */
class ExploreNetworkClient {
    private lateinit var client: Client

    fun start(port: Int = Networking.DEFAULT_PORT) {
        client = Client()
        client.start()

        // For consistency, the classes to be sent over the network are
        // registered by the same method for both the client and server.
        Networking.register(client)

        client.addListener(ThreadedListener(object : Listener() {
            override fun connected(connection: Connection) {}

            override fun received(connection: Connection, response: Any) {
                if (response is LoginResponse) {
                    println("Client got login response: $response")
                }
            }

            override fun disconnected(connection: Connection) {
                println("Client $connection - disconnected!")
                System.exit(0)
            }
        }))

        val host = "localhost"
        try {
            client.connect(5000, host, port, port + 1)
            // Server communication after connection can go here, or in Listener#connected().
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    fun doLogin() {
        val login = LoginRequest("milcho", "hash")
        val bytesSent = client.sendTCP(login)
        println("do login - bytes sent = $bytesSent")

    }
}