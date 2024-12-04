package solution.day4.model

import solution.model.grid.AbstractGrid

class WordGrid(elements: List<List<WordGridElement>>) : AbstractGrid<WordGridElement>(elements) {

    fun symbolAt(x: Int, y: Int): String {
        if (x in sizeRange && y in sizeRange) {
            return elements[x][y].symbol
        }
        return "$"
    }
}