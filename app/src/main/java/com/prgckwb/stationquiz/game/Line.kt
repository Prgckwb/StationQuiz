package com.prgckwb.stationquiz.game

data class Line(val stations :List<Station>, val lineName: String) {
        fun random(): Station{
            return stations.random()
        }
}