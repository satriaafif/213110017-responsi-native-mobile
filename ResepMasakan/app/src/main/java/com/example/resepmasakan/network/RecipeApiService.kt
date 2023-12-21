package com.example.resepmasakan.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RecipeApiService {
    private const val BASE_URL = "https://your-api-url.com/"

    val recipeApi: RecipeApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }
}
