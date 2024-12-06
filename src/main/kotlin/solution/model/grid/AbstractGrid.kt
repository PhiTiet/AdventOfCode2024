package solution.model.grid

abstract class AbstractGrid<E : AbstractGridElement>(protected val elements: List<List<E>>) {
    val size: Int = elements.size
    val sizeRange: IntRange = 0 until size

    init {
        isValidGrid(elements)
    }

    private fun isValidGrid(grid: List<List<E>>) {
        require(grid.isNotEmpty()) { "Grid must not be empty" }
        require(grid.all { row -> row.size == grid.size }) { "Grid must be square)" }
    }

    open operator fun get(x: Int, y: Int): E {
        return get(x, y) { it }
    }

    open operator fun <T> get(x: Int, y: Int, transform: (E) -> T): T {
        require((x in sizeRange) and (y in sizeRange)) { "Coordinates out of bounds" }
        return transform.invoke(elements[x][y])
    }

    fun firstIndexWhere(predicate: (E) -> Boolean): Pair<Int, Int> {
        for (i in 0 until size) {
            for (j in 0 until size) {
                if (predicate(elements[i][j])) {
                    return Pair(i, j)
                }
            }
        }
        throw IllegalStateException("no index found matching predicate")
    }

    fun displayGrid() {
        elements.forEach { row ->
            println(row.map { e -> e.symbol })
        }
    }
}