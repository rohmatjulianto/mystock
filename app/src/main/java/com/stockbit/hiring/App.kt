package com.stockbit.hiring

import android.app.Application
import com.stockbit.hiring.di.appComponent
import com.stockbit.hiring.ui.watchlist.WatchlistViewModel
import com.stockbit.remote.CryptoDataSource
import com.stockbit.remote.CryptoService
import com.stockbit.repository.CryptoRepository
import com.stockbit.repository.CryptoRepositoryImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // CONFIGURATION ---
    open fun configureDi() =
        startKoin {
            modules(provideComponent())
            modules(module)
        }

    // PUBLIC API ---
    open fun provideComponent() = appComponent

    val module = module {
        viewModel { WatchlistViewModel(get()) }
    }
}