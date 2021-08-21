package com.stockbit.remote

import com.stockbit.model.BaseResponse
import com.stockbit.model.CryptoResponse
import retrofit2.http.GET

interface CryptoService {
    @GET("data/top/totaltoptiervolfull?limit=30&tsym=IDR")
    suspend fun getCrypto() : BaseResponse<ArrayList<CryptoResponse>>
}