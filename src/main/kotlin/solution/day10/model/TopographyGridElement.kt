package solution.day10.model

import solution.model.grid.AbstractGridElement

class TopographyGridElement(symbol: String) : AbstractGridElement(symbol) {
    val height = symbol.toInt()
}