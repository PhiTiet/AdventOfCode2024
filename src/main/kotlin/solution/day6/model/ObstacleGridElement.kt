package solution.day6.model

import solution.model.Direction
import solution.model.grid.AbstractGridElement

class ObstacleGridElement(symbol: String) : AbstractGridElement(symbol) {
    fun isObstacle() : Boolean = symbol == "#"
    var visited = false
    val visitedWith: MutableSet<Direction> = mutableSetOf()
}