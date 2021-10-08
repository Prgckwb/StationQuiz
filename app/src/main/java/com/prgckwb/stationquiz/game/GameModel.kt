package com.prgckwb.stationquiz.game

import kotlin.random.Random

class GameModel {
    var score: Int = 0
    var questionNum: Int = 1
    val line = allLinesList.random()
    val totalStationsNum = line.stations.size
    var stationIndex = Random.nextInt(totalStationsNum)
    var currentStation: Station = line.stations[stationIndex]


    //    スコアを引数で与えた数だけ変更
    private fun changeScore(point: Int) {
        this.score += point
    }


    //    新しい駅をランダムで取得する
    fun getNextStation(): Station {
        this.stationIndex = Random.nextInt(this.totalStationsNum)

        while (line.stations[stationIndex] == currentStation) {
            stationIndex = Random.nextInt(this.totalStationsNum)
        }
        currentStation = line.stations[this.stationIndex]
        return currentStation
    }

    //    いま何問目かをインクリメントして返す
    fun getNextIncrementQuestionNum(): Int {
        return ++questionNum
    }

    //    入力した答えが正答と一致しているかを判断する
    fun checkAnswer(answer: String, step: Int): Boolean {
        val answerString = line.stations[(stationIndex + step) % this.totalStationsNum].name
        val answerList: MutableList<String> = mutableListOf()
        var uselessChar: Char? = null

        answerList.add(answerString)
        answerList.add(answerString + "駅")

        if (answerString.contains('（')) uselessChar = '（'
        if (answerString.contains('〈')) uselessChar = '〈'


        if (uselessChar != null) {
            val shortAnswerString = answerString.substringBefore(uselessChar)
            answerList.add(shortAnswerString)
            answerList.add(shortAnswerString + "駅")
        }

        return if (answerList.contains(answer)) {
            changeScore(20)
            currentStation = getNextStation()
            questionNum++
            true
        } else {
            changeScore(-10)
            false
        }
    }
}