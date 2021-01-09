package com.example.fighter

class RegisterRequest {
    private lateinit var pseudo: String
    private lateinit var password: String

    fun getPseudo(): String {
        return pseudo
    }

    fun setPseudo(pseudo: String) {
        this.pseudo = pseudo
    }

    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }
}