package com.example.framersmarkets.features.marketdetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.framersmarkets.R
import com.example.framersmarkets.base.fragment.BaseFragment
import com.example.framersmarkets.utils.Schedulers
import com.example.framersmarkets.utils.arg
import com.example.framersmarkets.utils.withArguments
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_market_details.*

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketDetailsFragment : BaseFragment() {

    override val layout = R.layout.fragment_market_details
    private val viewModel by viewModels<MarketDetailsViewModel>()
    private val marketId: Long by arg(MARKET_ID)
    private val farmsAdapter =
        MarketDetailsFarmAdapter(object : MarketDetailsFarmAdapter.ActionsHandler {
            override fun onClick(id: Long) {
                onFarmClick(id)
            }
        })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        farms_rv.layoutManager = GridLayoutManager(
            context,
            resources.getInteger(R.integer.market_details_farm_span_count)
        )
        farms_rv.adapter = farmsAdapter
        farms_rv.setHasFixedSize(true)
    }

    override fun onAttached() {
        viewModel.setUp(marketId)
        disposable += viewModel.market
            .observeOn(Schedulers.main)
            .subscribeBy(
                onNext = ::bindMarket,
                onError = ::onMarketError
            )
        disposable += viewModel.farms.subscribeBy(
            onNext = ::bindFarms,
            onError = ::onMarketError
        )
    }

    private fun bindMarket(market: MarketDetails) = with(market) {
        name_tv.text = name
        photo_slider.submitPhotos(photos)
        photo_slider.count = photosCount
        location_tv.text = location
        date_tv.text = workHours
        description_tv.text = description
    }

    private fun bindFarms(farms: List<MarketDetails.Farm>) {
        farmsAdapter.submitList(farms)
    }

    private fun onMarketError(throwable: Throwable) = with(throwable) {
        Toast.makeText(requireContext(), R.string.error, Toast.LENGTH_SHORT).show()
    }

    private fun onFarmClick(id: Long) {
        Toast.makeText(requireContext(), R.string.coming_soon, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun new(marketId: Long): MarketDetailsFragment {
            return MarketDetailsFragment().withArguments {
                putLong(MARKET_ID, marketId)
            }
        }

        private const val MARKET_ID = "MARKET_ID"
    }
}