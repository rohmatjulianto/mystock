package com.stockbit.remote

class CryptoDataSource(private val cryptoService: CryptoService) {

    suspend fun getResponse() = cryptoService.getCrypto()


}