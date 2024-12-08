package solution.day8.model

import solution.model.grid.AbstractGridElement

class AntennaGridElement(symbol: String) : AbstractGridElement(symbol) {
    var isAntiNode = false

    fun isAntenna(): Boolean {
        return symbol != "."
    }
}