package com.stockbit.hiring.ui.watchlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.ActivityMainBinding
import com.stockbit.hiring.databinding.FragmentWatchlistBinding
import com.stockbit.remote.CryptoService
import org.koin.android.ext.android.inject

class WatchlistFragment : Fragment() {
    lateinit var binding: FragmentWatchlistBinding
    val viewModel : WatchlistViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWatchlistBinding.inflate(inflater)

        viewModel.load()

        binding.rvWatchlist.layoutManager = LinearLayoutManager(context)
        viewModel.crypto.observe(viewLifecycleOwner, {
            it?.let {
                binding.pbWatchlist.visibility = View.GONE
                binding.rvWatchlist.adapter = WatchListAdapter(it)
            }
        })

        return binding.root
    }
}