package com.example.flowapp.service

import com.example.flowapp.model.Person
import retrofit2.http.GET

interface PersonService {

    companion object {
        const val BASE_URL = "https://api.agify.io/"
    }

    @GET("?name=bella")
    suspend fun getOnePerson() : Person

}