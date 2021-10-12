package com.prgckwb.stationquiz.game.data

import androidx.compose.ui.graphics.Color
import com.prgckwb.stationquiz.game.Line
import com.prgckwb.stationquiz.game.Station

val jrKyusyuLines = listOf(
    Line(
        lineName = "JR九州 鹿児島本線\n(下関・門司港～博多)",
        lineColor = Color(0xFFee3d49),
        stations = listOf(
            Station("下関"),
            Station("門司港"),
            Station("小森江"),
            Station("門司"),
            Station("小倉"),
            Station("西小倉"),
            Station("九州工大前"),
            Station("戸畑"),
            Station("枝光"),
            Station("スペースワールド"),
            Station("八幡"),
            Station("黒崎"),
            Station("陣原"),
            Station("折尾"),
            Station("水巻"),
            Station("遠賀川"),
            Station("海老津"),
            Station("教育大前"),
            Station("赤間"),
            Station("東郷"),
            Station("東福間"),
            Station("福間"),
            Station("千鳥"),
            Station("古賀"),
            Station("ししぶ"),
            Station("新宮中央"),
            Station("福工大前"),
            Station("九産大前"),
            Station("香椎"),
            Station("千早"),
            Station("箱崎"),
            Station("吉塚"),
            Station("博多"),
        )
    ),
    Line(
        lineName = "JR九州 鹿児島本線\n(博多～八代)",
        lineColor = Color(0xFFee3d49),
        stations = listOf(
            Station("博多"),
            Station("竹下"),
            Station("笹原"),
            Station("南福岡"),
            Station("春日"),
            Station("大野城"),
            Station("水城"),
            Station("都府楼南"),
            Station("二日市"),
            Station("天拝山"),
            Station("原田"),
            Station("けやき台"),
            Station("基山"),
            Station("弥生が丘"),
            Station("田代"),
            Station("鳥栖"),
            Station("肥前旭"),
            Station("久留米"),
            Station("荒木"),
            Station("西牟田"),
            Station("羽犬塚"),
            Station("筑後船小屋"),
            Station("瀬高"),
            Station("南瀬高"),
            Station("渡瀬"),
            Station("吉野"),
            Station("銀水"),
            Station("大牟田"),
            Station("荒尾"),
            Station("南荒尾"),
            Station("長洲"),
            Station("大野下"),
            Station("玉名"),
            Station("肥後伊倉"),
            Station("木葉"),
            Station("田原坂"),
            Station("植木"),
            Station("西里"),
            Station("崇城大学前"),
            Station("上熊本"),
            Station("熊本"),
            Station("西熊本"),
            Station("川尻"),
            Station("富合"),
            Station("宇土"),
            Station("松橋"),
            Station("小川"),
            Station("有佐"),
            Station("千丁"),
            Station("新八代"),
            Station("八代"),
        )
    ),
    Line(
        lineName = "JR九州 鹿児島本線\n(川内～鹿児島)",
        lineColor = Color(0xFFee3d49),
        stations = listOf(
            Station("博多"),
            Station("竹下"),
            Station("笹原"),
            Station("南福岡"),
            Station("春日"),
            Station("大野城"),
            Station("水城"),
            Station("都府楼南"),
            Station("二日市"),
            Station("天拝山"),
            Station("原田"),
            Station("けやき台"),
            Station("基山"),
            Station("弥生が丘"),
            Station("田代"),
            Station("鳥栖"),
            Station("肥前旭"),
            Station("久留米"),
            Station("荒木"),
            Station("西牟田"),
            Station("羽犬塚"),
            Station("筑後船小屋"),
            Station("瀬高"),
            Station("南瀬高"),
            Station("渡瀬"),
            Station("吉野"),
            Station("銀水"),
            Station("大牟田"),
            Station("荒尾"),
            Station("南荒尾"),
            Station("長洲"),
            Station("大野下"),
            Station("玉名"),
            Station("肥後伊倉"),
            Station("木葉"),
            Station("田原坂"),
            Station("植木"),
            Station("西里"),
            Station("崇城大学前"),
            Station("上熊本"),
            Station("熊本"),
            Station("西熊本"),
            Station("川尻"),
            Station("富合"),
            Station("宇土"),
            Station("松橋"),
            Station("小川"),
            Station("有佐"),
            Station("千丁"),
            Station("新八代"),
            Station("八代"),
        )
    ),
).sortedBy { it.lineName }