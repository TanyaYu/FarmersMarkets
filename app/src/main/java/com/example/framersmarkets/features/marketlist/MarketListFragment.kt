package com.example.framersmarkets.features.marketlist

import android.os.Bundle
import android.util.Log
import android.view.View
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
    private val adapter = MarketListAdapter(object : MarketListAdapter.ActionsHandler {
        override fun onClick(id: Long) {
            onMarketClick(id)
        }
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        markets_rv.adapter = adapter
        markets_rv.layoutManager = LinearLayoutManager(requireContext())
        markets_rv.setHasFixedSize(true)
    }

    override fun onAttached() {
        disposable += viewModel.markets.subscribeBy(
            onNext = ::bindMarketsList,
            onError = ::onMarketListError
        )
    }

    private fun bindMarketsList(markets: List<MarketItem>) = with(markets) {
        Log.d(javaClass.simpleName, toString())
        adapter.submitList(markets)
    }

    private fun onMarketListError(throwable: Throwable) = with(throwable) {
        Log.d(javaClass.simpleName, message.orEmpty())
        Toast.makeText(requireContext(), R.string.error, Toast.LENGTH_SHORT).show()
    }

    private fun onMarketClick(id: Long) {
        navigation.to(MarketDetailsFragment.new(id))
    }
}