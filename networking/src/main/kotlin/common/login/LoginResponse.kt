package common.login

/**
 * Written by Milcho on 5/21/2019.
 */
data class LoginResponse(var success: Boolean) {
    @Suppress("unused") // for kryonet
    constructor() : this(false)
}