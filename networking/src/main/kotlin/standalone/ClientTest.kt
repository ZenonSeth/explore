package standalone

import client.ExploreNetworkClient

/**
 * Written by Milcho on 5/21/2019.
 */
fun main () {
    val client = ExploreNetworkClient()
    client.start()
    Thread.sleep(1000)
    client.doLogin()
    Thread.sleep(50000)
    println("-- client thread terminated normally")
}
