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

    open operator fun get(y: Int, x: Int): E {
        return get(y, x) { it }
    }

    open operator fun <T> get(y: Int, x: Int, transform: (E) -> T): T {
        require((y in sizeRange) and (x in sizeRange)) { "Coordinates out of bounds" }
        return transform.invoke(elements[y][x])
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