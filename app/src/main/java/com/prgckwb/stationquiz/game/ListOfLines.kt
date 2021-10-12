package com.prgckwb.stationquiz.game

import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.ui.graphics.Color
import com.prgckwb.stationquiz.game.data.*

// lineColorは Color(0xFF(カラーコード))

// exmaple
//  Line(
//      lineName = "つまみびしょ濡れライン",
//      lineColor = Color(0xFF90e200),
//         stations = listOf(
//              Station(),
//          )
//  ),

val allLinesList = listOf(
//    JR
    jrHokkaidoLines, jrEastLines, jrTokaiLines, jrWestLines, jrShikokuLines, jrKyusyuLines,
//    首都圏地下鉄
    tokyoMetroLines, toeiChikatetsuLines,
//    大手私鉄
    keioLines, odakyuLines, seibuLines, keikyuLines, keiseiLines, tobuLines, tokyuLines,
//    その他
    chichibuTetsudoLines,
).flatten().distinct()