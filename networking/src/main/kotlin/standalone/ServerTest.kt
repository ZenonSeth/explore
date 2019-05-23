package standalone

import server.ExploreNetworkServer
import java.util.*

/**
 * Written by Milcho on 5/21/2019.
 */
fun main() {
    val server = ExploreNetworkServer()
    server.start()
    val scan = Scanner(System.`in`)
    var s = ""
    while (true) {
        print("\n> ")
        s = scan.nextLine()
        if (s.equals("exit",true)) {
            server.stop()
            return
        }
    }
}
