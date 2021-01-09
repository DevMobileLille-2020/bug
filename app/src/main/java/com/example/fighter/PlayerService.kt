package com.example.fighter

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PlayerService {
    @POST("/stephane/user/login")
    fun loginPlayer(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("/stephane/user/register")
    fun registerPlayer(@Body registerRequest: RegisterRequest): Call<RegisterResponse>

    @GET("/stephane/hero")
    fun getHeros(): Call<List<Heros>>
}