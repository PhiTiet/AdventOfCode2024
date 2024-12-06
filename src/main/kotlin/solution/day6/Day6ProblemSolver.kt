package solution.day6

import solution.AbstractProblemSolver
import solution.day6.model.ObstacleGrid
import solution.day6.model.ObstacleGridElement
import solution.model.Direction.Companion.toDirection

class Day6ProblemSolver : AbstractProblemSolver<Int>() {

    private val input = getProblemInput()

    private val grid =  ObstacleGrid(input.map { it.trim().toCharArray().toList().map { a -> ObstacleGridElement(a.toString()) } })

    override fun partOne(): Int {
        val (x,y) = grid.firstIndexWhere { (it.symbol != ".") and (it.symbol != "#") }
        val direction = toDirection(grid[x,y].symbol)

        while (x in grid.sizeRange && y in grid.sizeRange){
            grid[x,y].visited = true

        }
        return 0
    }

    override fun partTwo(): Int {
        return 0
    }
}