package com.prgckwb.stationquiz.game

class GameModel() {
    var score: Int = 0
    var questionNum: Int = 0
    val line = keioLine
    var stationNow : Station = line.random()


    fun changeScore(point: Int){
        this.score += point
    }

    fun getNextStation(): Station{
        var station = line.random()
        while(station == stationNow) station = line.random()
        stationNow = station
        return stationNow
    }

    fun checkAnswer(answer: String){
        if (answer == stationNow.name){
            changeScore(20)
            stationNow = getNextStation()
            questionNum++
        }else{
            changeScore(-10)
        }
    }
}