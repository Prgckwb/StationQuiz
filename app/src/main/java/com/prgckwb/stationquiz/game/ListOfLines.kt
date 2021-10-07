package com.prgckwb.stationquiz.game

import androidx.compose.ui.graphics.Color

// lineColorは Color(0xFF(カラーコード))

val allLinesList = listOf(
    Line(
        lineName = "京王線",
        lineColor = Color(0xFFdd0076),
        stations = listOf(
            Station("新宿"),
            Station("笹塚"),
            Station("代田橋"),
            Station("明大前"),
            Station("下高井戸"),
            Station("桜上水"),
            Station("上北沢"),
            Station("八幡山"),
            Station("芦花公園"),
            Station("千歳烏山"),
            Station("仙川"),
            Station("つつじヶ丘"),
            Station("柴崎"),
            Station("国領"),
            Station("布田"),
            Station("調布"),
            Station("西調布"),
            Station("飛田給"),
            Station("武蔵野台"),
            Station("多磨霊園"),
            Station("東府中"),
            Station("府中"),
            Station("分倍河原"),
            Station("中河原"),
            Station("聖蹟桜ヶ丘"),
            Station("百草園"),
            Station("高幡不動"),
            Station("南平"),
            Station("平山城址公園"),
            Station("長沼"),
            Station("北野"),
            Station("京王八王子"),
        )
    ),

    Line(
        lineName = "小田急線",
        lineColor = Color(0xFF2288cc),
        stations = listOf(
            Station("新宿"),
            Station("南新宿"),
            Station("参宮橋"),
            Station("代々木八幡"),
            Station("代々木上原"),
            Station("東北沢"),
            Station("下北沢"),
            Station("世田谷代田"),
            Station("梅ヶ丘"),
            Station("豪徳寺"),
            Station("経堂"),
            Station("千歳船橋"),
            Station("祖師ヶ谷大蔵"),
            Station("成城学園前"),
            Station("喜多見"),
            Station("狛江"),
            Station("和泉多摩川"),
            Station("登戸"),
            Station("向ヶ丘遊園"),
            Station("生田"),
            Station("読売ランド前"),
            Station("百合ヶ丘"),
            Station("新百合ヶ丘"),
            Station("柿生"),
            Station("鶴川"),
            Station("玉川学園前"),
            Station("町田"),
            Station("相模大野"),
            Station("小田急相模原"),
            Station("相武台前"),
            Station("座間"),
            Station("海老名"),
            Station("厚木"),
            Station("本厚木"),
            Station("愛甲石田"),
            Station("伊勢原"),
            Station("鶴巻温泉"),
            Station("東海大学前"),
            Station("秦野"),
            Station("渋沢"),
            Station("新松田"),
            Station("開成"),
            Station("栢山"),
            Station("富水"),
            Station("螢田"),
            Station("足柄"),
            Station("小田原"),
        )
    ),

    Line(
        lineName = "JR高崎線",
        lineColor = Color(0xFFf68b1e),
        stations = listOf(
            Station("上野"),
            Station("尾久"),
            Station("赤羽"),
            Station("浦和"),
            Station("さいたま新都心"),
            Station("大宮"),
            Station("宮原"),
            Station("上尾"),
            Station("北上尾"),
            Station("桶川"),
            Station("北本"),
            Station("鴻巣"),
            Station("北鴻巣"),
            Station("吹上"),
            Station("行田"),
            Station("熊谷"),
            Station("籠原"),
            Station("深谷"),
            Station("岡部"),
            Station("本庄"),
            Station("神保原"),
            Station("新町"),
            Station("倉賀野"),
            Station("高崎"),
        )
    ),

    Line(
        lineName = "東京メトロ銀座線",
        lineColor = Color(0xFFFF9500),
        stations = listOf(
            Station("浅草"),
            Station("田原町"),
            Station("稲荷町"),
            Station("上野"),
            Station("上野広小路"),
            Station("末広町"),
            Station("神田"),
            Station("三越前"),
            Station("日本橋"),
            Station("京橋"),
            Station("銀座"),
            Station("新橋"),
            Station("虎ノ門"),
            Station("溜池山王"),
            Station("赤坂見附"),
            Station("青山一丁目"),
            Station("外苑前"),
            Station("表参道"),
            Station("渋谷"),
        )
    ),

    Line(
        lineName = "東京メトロ丸の内線",
        lineColor = Color(0xFFF62E36),
        stations = listOf(
            Station("池袋"),
            Station("新大塚"),
            Station("茗荷谷"),
            Station("後楽園"),
            Station("本郷三丁目"),
            Station("御茶ノ水"),
            Station("淡路町"),
            Station("大手町"),
            Station("東京"),
            Station("銀座"),
            Station("霞ケ関"),
            Station("国会議事堂前"),
            Station("赤坂見附"),
            Station("四ツ谷"),
            Station("四谷三丁目"),
            Station("新宿御苑前"),
            Station("新宿三丁目"),
            Station("新宿"),
            Station("西新宿"),
            Station("中野坂上"),
            Station("新中野"),
            Station("東高円寺"),
            Station("新高円寺"),
            Station("南阿佐ケ谷"),
            Station("荻窪"),
            Station("中野新橋"),
            Station("中野富士見町"),
            Station("方南町"),
        )
    ),

    Line(
        lineName = "東京メトロ日比谷線",
        lineColor = Color(0xFFB5B5AC),
        stations = listOf(
            Station("北千住"),
            Station("南千住"),
            Station("三ノ輪"),
            Station("入谷"),
            Station("上野"),
            Station("仲御徒町"),
            Station("秋葉原"),
            Station("小伝馬町"),
            Station("人形町"),
            Station("茅場町"),
            Station("八丁堀"),
            Station("築地"),
            Station("東銀座"),
            Station("銀座"),
            Station("日比谷"),
            Station("霞ケ関"),
            Station("虎ノ門ヒルズ"),
            Station("神谷町"),
            Station("六本木"),
            Station("広尾"),
            Station("恵比寿"),
            Station("中目黒"),
        )
    ),


    Line(
        lineName = "東京メトロ東西線",
        lineColor = Color(0xFF009BBF),
        stations = listOf(
            Station("中野"),
            Station("落合"),
            Station("高田馬場"),
            Station("早稲田"),
            Station("神楽坂"),
            Station("飯田橋"),
            Station("九段下"),
            Station("竹橋"),
            Station("大手町"),
            Station("日本橋"),
            Station("茅場町"),
            Station("門前仲町"),
            Station("木場"),
            Station("東陽町"),
            Station("南砂町"),
            Station("西葛西"),
            Station("葛西"),
            Station("浦安"),
            Station("南行徳"),
            Station("行徳"),
            Station("妙典"),
            Station("原木中山"),
            Station("西船橋"),
        )
    ),

    Line(
        lineName = "東京メトロ千代田線",
        lineColor = Color(0xFF00BB85),
        stations = listOf(
            Station("北綾瀬"),
            Station("綾瀬"),
            Station("北千住"),
            Station("町屋"),
            Station("西日暮里"),
            Station("千駄木"),
            Station("根津"),
            Station("湯島"),
            Station("新御茶ノ水"),
            Station("大手町"),
            Station("二重橋前"),
            Station("日比谷"),
            Station("霞ケ関"),
            Station("国会議事堂前"),
            Station("赤坂"),
            Station("乃木坂"),
            Station("表参道"),
            Station("明治神宮前〈原宿〉"),
            Station("代々木公園"),
            Station("代々木上原"),
        )
    ),

    Line(
        lineName = "東京メトロ有楽町線",
        lineColor = Color(0xFFC1A470),
        stations = listOf(
            Station("和光市"),
            Station("地下鉄成増"),
            Station("地下鉄赤塚"),
            Station("平和台"),
            Station("氷川台"),
            Station("小竹向原"),
            Station("千川"),
            Station("要町"),
            Station("池袋"),
            Station("東池袋"),
            Station("護国寺"),
            Station("江戸川橋"),
            Station("飯田橋"),
            Station("市ケ谷"),
            Station("麹町"),
            Station("永田町"),
            Station("桜田門"),
            Station("有楽町"),
            Station("銀座一丁目"),
            Station("新富町"),
            Station("月島"),
            Station("豊洲"),
            Station("辰巳"),
            Station("新木場"),

        )
    ),

    Line(
        lineName = "東京メトロ半蔵門線線",
        lineColor = Color(0xFF8F76D6),
        stations = listOf(
            Station("渋谷"),
            Station("表参道"),
            Station("青山一丁目"),
            Station("永田町"),
            Station("半蔵門"),
            Station("九段下"),
            Station("神保町"),
            Station("大手町"),
            Station("三越前"),
            Station("水天宮前"),
            Station("清澄白河"),
            Station("住吉"),
            Station("錦糸町"),
            Station("押上〈スカイツリー前〉"),
        )
    ),

    Line(
        lineName = "東京メトロ南北線",
        lineColor = Color(0xFF00AC9B),
        stations = listOf(
            Station("赤羽岩淵"),
            Station("志茂"),
            Station("王子神谷"),
            Station("王子"),
            Station("西ケ原"),
            Station("駒込"),
            Station("本駒込"),
            Station("東大前"),
            Station("後楽園"),
            Station("飯田橋"),
            Station("市ケ谷"),
            Station("四ツ谷"),
            Station("永田町"),
            Station("溜池山王"),
            Station("六本木一丁目"),
            Station("麻布十番"),
            Station("白金高輪"),
            Station("白金台"),
            Station("目黒"),
        )
    ),

    Line(
        lineName = "東京メトロ副都心線",
        lineColor = Color(0xFF9C5E31),
        stations = listOf(
            Station("和光市"),
            Station("地下鉄成増"),
            Station("地下鉄赤塚"),
            Station("平和台"),
            Station("氷川台"),
            Station("小竹向原"),
            Station("千川"),
            Station("要町"),
            Station("池袋"),
            Station("雑司が谷"),
            Station("西早稲田"),
            Station("東新宿"),
            Station("新宿三丁目"),
            Station("北参道"),
            Station("明治神宮前〈原宿〉"),
            Station("渋谷"),
        )
    ),

    Line(
        lineName = "都営浅草線",
        lineColor = Color(0xFFE85298),
        stations = listOf(
            Station("西馬込"),
            Station("馬込"),
            Station("中延"),
            Station("戸越"),
            Station("五反田"),
            Station("高輪台"),
            Station("泉岳寺"),
            Station("三田"),
            Station("大門"),
            Station("新橋"),
            Station("東銀座"),
            Station("宝町"),
            Station("日本橋"),
            Station("人形町"),
            Station("東日本橋"),
            Station("浅草橋"),
            Station("蔵前"),
            Station("浅草"),
            Station("本所吾妻橋"),
            Station("押上（スカイツリー前）"),
        )
    ),

    Line(
        lineName = "都営三田線",
        lineColor = Color(0xFF0079c2),
        stations = listOf(
            Station("目黒"),
            Station("白金台"),
            Station("白金高輪"),
            Station("三田"),
            Station("芝公園"),
            Station("御成門"),
            Station("内幸町"),
            Station("日比谷"),
            Station("大手町"),
            Station("神保町"),
            Station("水道橋"),
            Station("春日"),
            Station("白山"),
            Station("千石"),
            Station("巣鴨"),
            Station("西巣鴨"),
            Station("新板橋"),
            Station("板橋区役所前"),
            Station("板橋本町"),
            Station("本蓮沼"),
            Station("志村坂上"),
            Station("志村三丁目"),
            Station("蓮根"),
            Station("西台"),
            Station("高島平"),
            Station("新高島平"),
            Station("西高島平"),
        )
    ),

    Line(
        lineName = "都営新宿線",
        lineColor = Color(0xFF6cbb5a),
        stations = listOf(
            Station("新宿"),
            Station("新宿三丁目"),
            Station("曙橋"),
            Station("市ヶ谷"),
            Station("九段下"),
            Station("神保町"),
            Station("小川町"),
            Station("岩本町"),
            Station("馬喰横山"),
            Station("浜町"),
            Station("森下"),
            Station("菊川"),
            Station("住吉"),
            Station("西大島"),
            Station("大島"),
            Station("東大島"),
            Station("船堀"),
            Station("一之江"),
            Station("瑞江"),
            Station("篠崎"),
            Station("本八幡"),
        )
    ),

    Line(
        lineName = "都営大江戸線",
        lineColor = Color(0xFFb6007a),
        stations = listOf(
            Station("都庁前"),
            Station("新宿西口"),
            Station("東新宿"),
            Station("若松河田"),
            Station("牛込柳町"),
            Station("牛込神楽坂"),
            Station("飯田橋"),
            Station("春日"),
            Station("本郷三丁目"),
            Station("上野御徒町"),
            Station("新御徒町"),
            Station("蔵前"),
            Station("両国"),
            Station("森下"),
            Station("清澄白河"),
            Station("門前仲町"),
            Station("月島"),
            Station("勝どき"),
            Station("築地市場"),
            Station("汐留"),
            Station("大門"),
            Station("赤羽橋"),
            Station("麻布十番"),
            Station("六本木"),
            Station("青山一丁目"),
            Station("国立競技場"),
            Station("代々木"),
            Station("新宿"),
            Station("西新宿五丁目"),
            Station("中野坂上"),
            Station("東中野"),
            Station("中井"),
            Station("落合南長崎"),
            Station("新江古田"),
            Station("練馬"),
            Station("豊島園"),
            Station("練馬春日町"),
            Station("光が丘"),
        )
    )
)