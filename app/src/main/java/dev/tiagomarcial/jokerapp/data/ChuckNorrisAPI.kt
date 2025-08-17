package dev.tiagomarcial.jokerapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisAPI {


    @GET("jokes/categories")
    fun findAllCategories(@Query("apiKey") apikey: String) : Call<List<String>>
}