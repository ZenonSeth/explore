package common.login

/**
 * Written by Milcho on 5/21/2019.
 */
data class LoginRequest(var username: String, var password: String) {
    @Suppress("unused") // for kryonet
    constructor () : this("","")
}
