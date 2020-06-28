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
fun Market.toDetails() = MarketDetails(
    id = id,
    name = name,
    location = "Concord, NH",
    photos = listOf("https://cdn.vox-cdn.com/thumbor/K7pJk3lLSH60zEbktRL0AQ-jNfA=/0x0:4500x2994/1200x900/filters:focal(1890x1137:2610x1857)/cdn.vox-cdn.com/uploads/chorus_image/image/65219436/6329735393_3a905a118a_o.0.jpg",
        "https://res.cloudinary.com/culturemap-com/image/upload/ar_4:3,c_fill,g_faces:center,w_320/v1538215499/photos/282603_original.jpg",
    "https://southsoundmag.com/wp-content/uploads/2019/06/Photo-by-Daria-Shevtsova-via-Pexels-e1559759504402.jpg"),
    photosCount = 3,
    workHours = "Every Sunday and Saturday 10 - 12 am",
    description = "A food market at which local farmers sell fruit and vegetables and often meat, cheese, and bakery products directly to consumers.",
    farms = listOf(
        MarketDetails.Farm(1, "Tanya's Farm", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTBrJF8UhlCcZsaJGuPztlItkvQ1jUBBIj6ZA&usqp=CAU"),
        MarketDetails.Farm(2, "Hopewell Farms", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSzYMHveAzlwQ_2GSPQVhz8HCAaa7h3xt6kDA&usqp=CAU"),
        MarketDetails.Farm(3, "BrookFord Farm", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTIs-JTQSDZMII9FcGLI4pDDF37mVnoHb-LMQ&usqp=CAU"),
        MarketDetails.Farm(4, "Milk Farm", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTzihmVR1ZeA3_edbNMvtfmFbDwf-iJ3J-riA&usqp=CAU"),
        MarketDetails.Farm(5, "Cheese Farm", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTMZ0mzKzIA5yaONsAV3sEwp25npzURPtD0tg&usqp=CAU"),
        MarketDetails.Farm(6, "Farm", ""),
        MarketDetails.Farm(7, "Farm", ""),
        MarketDetails.Farm(8, "Farm", "")
    )
)