package com.prgckwb.stationquiz.game

data class Line(val stations :List<Station>, val lineName: String) {
    val firstStation = stations[0]
    val lastStation = stations[stations.size-1]

    fun random(): Station{
        return stations.random()
    }

    fun getLineDirectText(direction: Int): String{
        val arrow = if(direction > 0) "->" else "<-"
        return "${firstStation.name} $arrow ${lastStation.name}"
    }
}