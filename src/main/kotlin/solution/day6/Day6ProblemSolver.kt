package solution.day6

import solution.AbstractProblemSolver
import solution.day6.model.ObstacleGrid
import solution.day6.model.ObstacleGridElement
import solution.model.Direction.Companion.move
import solution.model.Direction.Companion.toDirection

class Day6ProblemSolver : AbstractProblemSolver<Int>() {

    private val input = getProblemInput()

    private val grid =  ObstacleGrid(input.map { it.trim().toCharArray().toList().map { a -> ObstacleGridElement(a.toString()) } })

    override fun partOne(): Int {
        var (y,x) = grid.firstIndexWhere { (it.symbol != ".") and (it.symbol != "#") }
        var direction = toDirection(grid[y,x].symbol)

        while (y in grid.sizeRange && x in grid.sizeRange){
            grid[y,x].visited = true
            val (aheadY, aheadX) = move(y,x, direction)
            if (grid[aheadY,aheadX].isObstacle()){
                direction = direction.right()
            }
            val (nextY, nextX) = move(y,x,direction)
            y = nextY
            x = nextX
        }
        return grid.count{it.visited}
    }

    override fun partTwo(): Int {
        return 0
    }
}