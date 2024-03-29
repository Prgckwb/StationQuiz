package com.prgckwb.stationquiz.game

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.math.min
import kotlin.random.Random

class GameModel(val currentLine: Line = allLinesList.random()): ViewModel() {
    init {
        Log.d("DEBUG", "GameModel 初期化")
    }
    var score: Int = 0
    var questionNum: Int = 1
    val totalStationsNum = currentLine.stations.size
    val totalLinesNum = allLinesList.size
    var stationIndex = Random.nextInt(totalStationsNum)
    var currentStation: Station = currentLine.stations[stationIndex]

    companion object{
        fun findLine(lineName: String?): Line {
            for (line in allLinesList) {
                if (line.lineName == lineName) return line
            }
            return allLinesList[0]
        }

        fun findLines(lineName: String?): List<Line>{
            val list = mutableListOf<Line>()

            return if (lineName == null){
                list
            }else{
                for( line in allLinesList){
                    if(line.lineName.contains(lineName)) list.add(line)
                }
                list
            }
        }
    }


    //    スコアを引数で与えた数だけ変更
    private fun changeScore(point: Int) {
        this.score += point
    }




    //    新しい駅をランダムで取得する
    fun getNextStation(): Station {
        this.stationIndex = Random.nextInt(this.totalStationsNum - 1)

        while (currentLine.stations[stationIndex] == currentStation) {
            stationIndex = Random.nextInt(this.totalStationsNum - 1)
        }
        currentStation = currentLine.stations[this.stationIndex]
        return currentStation
    }

    //    いま何問目かをインクリメントして返す
    fun getNextIncrementQuestionNum(): Int {
        return ++questionNum
    }

    //    入力した答えが正答と一致しているかを判断する
    fun checkAnswer(answer: String, step: Int): Boolean {
        val answerString = currentLine.stations[(stationIndex + step) % this.totalStationsNum].name
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

    //    optionsNum 個の選択肢を返す関数
//    返すリストにはstep先の答え駅も含む

    //    **二択だとバグが出る**
    fun getStationOptions(optionsNum: Int = 4, step: Int): MutableList<Station> {
        val num = min(optionsNum, totalStationsNum)
        val shuffledLine: MutableList<Station> = currentLine.stations.shuffled() as MutableList<Station>
        val answerStation: Station = currentLine.stations[(stationIndex + step) % totalStationsNum]

        shuffledLine.remove(currentStation)

        val reShuffledLine: MutableList<Station> = shuffledLine.take(num - 1) as MutableList<Station>
        reShuffledLine.add(answerStation)
        reShuffledLine.shuffle()

        return reShuffledLine
    }
}