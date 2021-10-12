package com.prgckwb.stationquiz.game.data

import androidx.compose.ui.graphics.Color
import com.prgckwb.stationquiz.game.Line
import com.prgckwb.stationquiz.game.Station

// 地方鉄道
val chichibuTetsudoLines = listOf(
    //    秩父鉄道
    Line(
        lineName = "秩父鉄道 秩父本線",
        lineColor = Color.Blue,
        stations = listOf(
            Station("羽生"),
            Station("西羽生"),
            Station("新郷"),
            Station("武州荒木"),
            Station("東行田"),
            Station("行田市"),
            Station("持田"),
            Station("ソシオ流通センター"),
            Station("熊谷"),
            Station("上熊谷"),
            Station("石原"),
            Station("ひろせ野鳥の森"),
            Station("大麻生"),
            Station("明戸"),
            Station("武川"),
            Station("永田"),
            Station("ふかや花園"),
            Station("小前田"),
            Station("桜沢"),
            Station("寄居"),
            Station("波久礼"),
            Station("樋口"),
            Station("野上"),
            Station("長瀞"),
            Station("上長瀞"),
            Station("親鼻"),
            Station("皆野"),
            Station("和銅黒谷"),
            Station("大野原"),
            Station("秩父"),
            Station("御花畑"),
            Station("影森"),
            Station("浦山口"),
            Station("武州中川"),
            Station("武州日野"),
            Station("白久"),
            Station("三峰口"),
        )
    ),
).sortedBy { it.lineName }