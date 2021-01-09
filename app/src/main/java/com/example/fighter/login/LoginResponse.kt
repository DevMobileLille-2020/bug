package com.example.fighter

class LoginResponse {
    private lateinit var id: String
    private lateinit var pseudo: String
    private lateinit var password: String

    fun getId(): String {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

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