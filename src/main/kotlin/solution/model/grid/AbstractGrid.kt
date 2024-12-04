package solution.model.grid

abstract class AbstractGrid<E : AbstractGridElement>(protected val elements: List<List<E>>) {
    val size: Int = elements.size
    val sizeRange: IntRange = 0 until size

    init {
        isValidGrid(elements)
    }

    private fun isValidGrid(grid: List<List<E>>) {
        require(grid.all { row -> row.size == grid.size }) { "Grid must be square)" }
        require(grid.isNotEmpty()) { "Grid must not be empty" }
    }

    open operator fun get(x: Int, y: Int): E {
        require(x in sizeRange && y in sizeRange) { "Coordinates out of bounds" }
        return elements[x][y]
    }

    fun displayGrid() {
        elements.forEach { row ->
            println(row.map { e -> e.symbol })
        }
    }
}