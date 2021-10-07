package com.prgckwb.stationquiz.game

data class Line(val stations: List<Station>, val lineName: String) {
    val firstStation = stations[0]
    val lastStation = stations[stations.size - 1]

    fun getLineDirectText(direction: Int): String {
        return if (direction > 0) {
            "[下り] ${firstStation.name} -> ${lastStation.name}"
        } else {
            "[上り] ${lastStation.name} -> ${firstStation.name}"
        }
    }
}