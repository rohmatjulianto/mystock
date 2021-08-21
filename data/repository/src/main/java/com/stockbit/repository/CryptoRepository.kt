package com.stockbit.repository

import com.stockbit.model.BaseResponse
import com.stockbit.model.CryptoResponse
import com.stockbit.remote.CryptoDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.delay

interface CryptoRepository {
    suspend fun getResponse() : Flow<BaseResponse<ArrayList<CryptoResponse>>>
}

class CryptoRepositoryImpl(private val dataSource: CryptoDataSource) : CryptoRepository{
    override suspend fun getResponse(): Flow<BaseResponse<ArrayList<CryptoResponse>>> {
        return flow {
            while(true) {
                val result = dataSource.getResponse()
                emit(result)
                delay(8000L)
            }
        }
    }
}