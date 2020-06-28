package com.example.framersmarkets.features.marketlist

import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.framersmarkets.R
import com.example.framersmarkets.base.fragment.BaseFragment
import com.example.framersmarkets.features.marketdetails.MarketDetailsFragment
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_market_list.*

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketListFragment : BaseFragment() {

    override val layout = R.layout.fragment_market_list
    private val viewModel by viewModels<MarketListViewModel>()
    private val marketsAdapter = MarketListAdapter(object : MarketListAdapter.ActionsHandler {
        override fun onClick(id: Long) {
            navigation.to(MarketDetailsFragment.new(id))
        }
    })

    override fun onReady() {
        with(markets_rv) {
            adapter = marketsAdapter
            layoutManager = LinearLayoutManager(this@MarketListFragment.requireContext())
            setHasFixedSize(true)
        }
        disposable += viewModel.markets.subscribeBy(
            onNext = ::bindMarketsList,
            onError = ::onMarketListError
        )
    }

    private fun bindMarketsList(markets: List<MarketItem>) {
        Log.d(javaClass.simpleName, markets.toString())
        marketsAdapter.submitList(markets)
    }

    private fun onMarketListError(throwable: Throwable) {
        Log.d(javaClass.simpleName, throwable.message.orEmpty())
        Toast.makeText(requireContext(), R.string.error, Toast.LENGTH_SHORT).show()
    }
}