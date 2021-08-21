package com.stockbit.hiring.ui.watchlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stockbit.common.base.BaseViewModel
import com.stockbit.model.CryptoModel
import com.stockbit.repository.CryptoRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class WatchlistViewModel(val cryptoRepository: CryptoRepository) : BaseViewModel() {

    private val _crpto = MutableLiveData<ArrayList<CryptoModel>>()
    val crypto : LiveData<ArrayList<CryptoModel>> = _crpto

    fun load(){
        viewModelScope.launch {
            val result = cryptoRepository.getResponse()
            result.collect {
                val items : ArrayList<CryptoModel> = ArrayList()
                it.data?.map {
                    items.add(
                        CryptoModel(
                            it.coinInfo.name,
                            it.coinInfo.fullName,
                            it.raw.rawDetail.price,
                            it.raw.rawDetail.changeHour,
                            it.raw.rawDetail.changePCTHour
                        )
                    )
                }
                _crpto.postValue(items)
            }
        }
    }
}