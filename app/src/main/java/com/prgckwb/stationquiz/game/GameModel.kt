package com.prgckwb.stationquiz.game

import kotlin.random.Random

class GameModel() {
    var score: Int = 0
    var questionNum: Int = 1
    val line = keioLine
    val stationsNum = line.stations.size
    var stationIndex = Random.nextInt(stationsNum)
    var stationNow : Station = line.stations[stationIndex]


//    スコアを引数で与えた数だけ変更
    private fun changeScore(point: Int){
        this.score += point
    }

//    新しい駅をランダムで取得する
    fun getNextStation(): Station{
        this.stationIndex = Random.nextInt(this.stationsNum)

        while(line.stations[stationIndex] == stationNow){
            stationIndex = Random.nextInt(this.stationsNum)
        }
        stationNow = line.stations[this.stationIndex]
        return stationNow
    }

//    いま何問目かをインクリメントして返す
    fun getNextQuestionNum(): Int{
        return ++questionNum
    }

//    入力した答えが正答と一致しているかを判断する
    fun checkAnswer(answer: String, step: Int){
        if (answer == line.stations[(stationIndex + step) % this.stationsNum].name){
            changeScore(20)
            stationNow = getNextStation()
            questionNum++
        }else{
            changeScore(-10)
        }
    }

}