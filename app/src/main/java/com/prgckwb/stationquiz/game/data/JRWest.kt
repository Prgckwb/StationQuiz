package com.prgckwb.stationquiz.game.data

import androidx.compose.ui.graphics.Color
import com.prgckwb.stationquiz.game.Line
import com.prgckwb.stationquiz.game.Station

val jrWestLines = listOf(
    Line(
        lineName = "JR西日本 大阪環状線",
        lineColor = Color(0xFFe73042),
        stations = listOf(
            Station("天王寺"),
            Station("新今宮"),
            Station("今宮"),
            Station("芦原橋"),
            Station("大正"),
            Station("弁天町"),
            Station("西九条"),
            Station("野田"),
            Station("福島"),
            Station("大阪"),
            Station("天満"),
            Station("桜ノ宮"),
            Station("京橋"),
            Station("大阪城公園"),
            Station("森ノ宮"),
            Station("玉造"),
            Station("鶴橋"),
            Station("桃谷"),
            Station("寺田町"),
        )
    ),
    Line(
        lineName = "JR西日本 宝塚線",
        lineColor = Color(0xFFfcc800),
        stations = listOf(
            Station("新大阪"),
            Station("大阪"),
            Station("尼崎"),
            Station("塚口"),
            Station("猪名寺"),
            Station("伊丹"),
            Station("北伊丹"),
            Station("川西池田"),
            Station("中山寺"),
            Station("宝塚"),
            Station("生瀬"),
            Station("西宮名塩"),
            Station("武田尾"),
            Station("道場"),
            Station("三田"),
            Station("新三田"),
            Station("広野"),
            Station("相野"),
            Station("藍本"),
            Station("草野"),
            Station("古市"),
            Station("南矢代"),
            Station("篠山口"),
        )
    ),
    Line(
        lineName = "JR西日本 福知山線\n(篠山口～福知山)",
        lineColor = Color(0xFFfcc800),
        stations = listOf(
            Station("篠山口"),
            Station("丹波大山"),
            Station("下滝"),
            Station("谷川"),
            Station("柏原"),
            Station("石生"),
            Station("黒井"),
            Station("市島"),
            Station("丹波竹田"),
            Station("福知山"),
        )
    ),
    Line(
        lineName = "JR西日本 東西線",
        lineColor = Color(0xFFe73082),
        stations = listOf(
            Station("京橋"),
            Station("大阪城北詰"),
            Station("大阪天満宮"),
            Station("北新地"),
            Station("新福島"),
            Station("海老江"),
            Station("御幣島"),
            Station("加島"),
            Station("尼崎"),
        )
    ),
).sortedBy { it.lineName }