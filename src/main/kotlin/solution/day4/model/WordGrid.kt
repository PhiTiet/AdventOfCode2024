package solution.day4.model

import solution.model.grid.AbstractGrid

class WordGrid(elements: List<List<WordGridElement>>) : AbstractGrid<WordGridElement>(elements) {
    fun symbolAt(y: Int, x: Int): String {
        if (y in sizeRange && x in sizeRange) {
            return elements[y][x].symbol
        }
        return "$"
    }
}