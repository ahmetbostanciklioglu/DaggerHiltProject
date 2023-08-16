package com.ahmet.bostanciklioglu.jetpackcomposeappwithmvvm.service

import com.ahmet.bostanciklioglu.jetpackcomposeappwithmvvm.model.ExampleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Inject

interface  GetApi {
    @GET("END_POINT")
    suspend fun getApi(): Response<List<ExampleModel>>
}
class ApiService @Inject constructor(
    private val getApi: GetApi
) {
    suspend fun getDataFromNetwork(): List<ExampleModel> {
        return withContext(Dispatchers.IO) {
            val datas = getApi.getApi()
            datas.body() ?: emptyList()
        }
    }
}

