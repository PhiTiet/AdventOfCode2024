package solution.day4.model

import solution.model.grid.AbstractGrid

class WordGrid(elements: List<List<WordGridElement>>) : AbstractGrid<WordGridElement>(elements) {

    override operator fun get(x: Int, y: Int): WordGridElement {
        if (x in sizeRange && y in sizeRange) {
            return elements[x][y]
        }
        return WordGridElement("Q")
    }
}