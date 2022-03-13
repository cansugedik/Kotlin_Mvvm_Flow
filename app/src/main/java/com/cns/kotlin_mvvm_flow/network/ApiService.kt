package com.example.kotlin_flow_mvvm.network

import com.example.kotlin_flow_mvvm.model.CommentModel
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("/comments/{id}")
    suspend fun getComments(@Path("id") id: Int): CommentModel

}