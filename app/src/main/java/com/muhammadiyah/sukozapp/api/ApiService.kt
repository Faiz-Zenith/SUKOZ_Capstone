package com.muhammadiyah.sukozapp.api

import com.muhammadiyah.sukozapp.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("categories")
    fun getCategories(): Call<List<Category>>
}
