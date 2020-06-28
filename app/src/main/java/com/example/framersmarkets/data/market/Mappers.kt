package com.example.framersmarkets.data.market

import com.example.framersmarkets.features.marketdetails.MarketDetails
import com.example.framersmarkets.features.marketlist.MarketItem

/**
 * Author: Tanya Iuferova
 * Date: 6/27/20
 */
fun Market.toItem() = MarketItem(id, name)
fun Market.toDetails() = MarketDetails(id.toString(), name)