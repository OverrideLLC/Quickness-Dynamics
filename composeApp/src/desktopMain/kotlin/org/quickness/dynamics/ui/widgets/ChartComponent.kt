package org.quickness.dynamics.ui.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import io.github.koalaplot.core.line.LinePlot
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.DefaultPoint
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.autoScaleXRange
import io.github.koalaplot.core.xygraph.autoScaleYRange
import io.github.koalaplot.core.xygraph.rememberAxisStyle
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
fun ChartComponent(
    data: List<Float>,
    data2: List<Float>,
    data3: List<Float>
) {
    val dataList = buildList {
        for (i in data.indices) {
            add(DefaultPoint(i.toFloat(), data[i]))
        }
    }
    val dataList2 = buildList {
        for (i in data2.indices) {
            add(DefaultPoint(i.toFloat(), data2[i]))
        }
    }
    val dataList3 = buildList {
        for (i in data3.indices) {
            add(DefaultPoint(i.toFloat(), data3[i]))
        }
    }
    XYGraph(
        xAxisModel = rememberFloatLinearAxisModel(dataList.autoScaleXRange()),
        yAxisModel = rememberFloatLinearAxisModel(dataList.autoScaleYRange()),
        zoomEnabled = true,
        allowIndependentZoom = true,
        xAxisStyle = rememberAxisStyle(
            color = Color.Black,
            majorTickSize = 16.dp,
        ),
        yAxisStyle = rememberAxisStyle(
            color = Color.Black,
            majorTickSize = 16.dp,
        ),

    ) {
        LinePlot(
            data = dataList,
            lineStyle = LineStyle(SolidColor(Color.Blue))
        )
        LinePlot(
            data = dataList2,
            lineStyle = LineStyle(SolidColor(Color.Red))
        )
        LinePlot(
            data = dataList3,
            lineStyle = LineStyle(SolidColor(Color.Yellow))
        )
    }
}
