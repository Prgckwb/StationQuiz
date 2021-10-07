package com.prgckwb.stationquiz.game

import androidx.compose.ui.graphics.Color


data class Line(
    val stations: List<Station>,
    val lineName: String,
    val lineColor: Color = Color.LightGray,

    ) {

    val firstStation = stations[0]
    val lastStation = stations[stations.size - 1]

    fun getLineDirectText(direction: Int): String {
        return if (direction > 0) {
            "${firstStation.name} -> ${lastStation.name}"
        } else {
            "${lastStation.name} -> ${firstStation.name}"
        }
    }
}