package com.example.framersmarkets.features.marketdetails

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
data class MarketDetails(
    val id: Long,
    val name: String,
    val photos: List<String>,
    val photosCount: Int,
    val location: String,
    val workHours: String,
    val farms: List<Farm>,
    val description: String
) {
    data class Farm(
        val id: Long,
        val name: String,
        val logo: String
    )
}