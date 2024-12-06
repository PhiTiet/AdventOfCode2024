package solution.day6

import solution.AbstractProblemSolver
import solution.day6.model.ObstacleGrid
import solution.day6.model.ObstacleGridElement
import solution.model.Direction
import solution.model.Direction.Companion.move
import solution.model.Direction.Companion.toDirection

class Day6ProblemSolver : AbstractProblemSolver<Int>() {

    private val input = getProblemInput()

    private val grid =  ObstacleGrid(input
            .map { it.trim().toCharArray().toList().map { a -> ObstacleGridElement(a.toString()) }.toMutableList() }
            .toMutableList())

    override fun partOne(): Int {
        traverseGrid()
        return grid.count { it.visited }
    }
    override fun partTwo(): Int {
        traverseGrid()
        val test = grid
        return 0
    }

    private fun traverseGrid() : Boolean {
        var (y, x) = grid.firstIndexWhere { (it.symbol != ".") and (it.symbol != "#") }
        var direction = toDirection(grid[y, x].symbol)
        val visited: MutableMap<Pair<Int, Int>, MutableSet<Direction>> = mutableMapOf()

        while (y in grid.sizeRange && x in grid.sizeRange) {
            if (visited.containsKey(Pair(y,x)) && visited[Pair(y, x)]!!.contains(direction)) {
                return true
            }

            if (visited.containsKey(Pair(y,x))){
                visited[Pair(y,x)]!!.add(direction)
            }
            grid[y, x].visited = true
            val (aheadY, aheadX) = move(y, x, direction)
            if (aheadY !in grid.sizeRange || aheadX !in grid.sizeRange) {
                break
            }
            if (grid[aheadY, aheadX].isObstacle()) {
                direction = direction.right()
            }
            val (nextY, nextX) = move(y, x, direction)
            y = nextY
            x = nextX
        }
        return false
    }


}