package com.example.framersmarkets.data.market

import com.example.framersmarkets.features.marketdetails.MarketDetails
import com.example.framersmarkets.features.marketlist.MarketItem

/**
 * Author: Tanya Iuferova
 * Date: 6/27/20
 */
fun Market.toItem() = MarketItem(
    id = id,
    name = name,
    location = "Concord, NH",
    date = "Sat, Sun",
    photo = "https://res.cloudinary.com/culturemap-com/image/upload/ar_4:3,c_fill,g_faces:center,w_320/v1538215499/photos/282603_original.jpg"
)
fun Market.toDetails() = MarketDetails(id.toString(), name)