package solution.day6

import solution.AbstractProblemSolver
import solution.day6.model.ObstacleGrid
import solution.day6.model.ObstacleGridElement
import solution.model.Direction.Companion.move
import solution.model.Direction.Companion.toDirection

class Day6ProblemSolver : AbstractProblemSolver<Int>() {

    private val input = getProblemInput()

    private lateinit var grid: ObstacleGrid

    override fun partOne(): Int {
        grid = readGrid()
        traverseGrid()
        return grid.count { it.visited }
    }

    override fun partTwo(): Int {
        grid = readGrid()
        traverseGrid()
        val visitedIndexes = grid.allIndexesWhere { it.visited }.minus(startingIndex())
        return visitedIndexes
            .map { getsStuckInLoop(gridWithBlockade(it)) }
            .count{it}
    }

    private fun gridWithBlockade(blockade: Pair<Int, Int>): ObstacleGrid {
        val grid = readGrid()
        grid[blockade.first, blockade.second].symbol= "#"
        return grid
    }

    private fun traverseGrid() : Boolean {
        var (y, x) = startingIndex()
        var direction = toDirection(grid[y, x].symbol)
        while (y in grid.sizeRange && x in grid.sizeRange) {
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

    private fun startingIndex() = grid.firstIndexWhere { (it.symbol != ".") and (it.symbol != "#") }

    private fun getsStuckInLoop(obstacleGrid: ObstacleGrid) : Boolean {
        var (y, x) = startingIndex()
        var direction = toDirection(obstacleGrid[y, x].symbol)

        while (y in obstacleGrid.sizeRange && x in obstacleGrid.sizeRange) {
            val current = obstacleGrid[y,x]
            if (current.visitedWith.contains(direction))  {
                return true
            }
            else {
                current.visitedWith.add(direction)
            }

            val (aheadY, aheadX) = move(y, x, direction)
            if (aheadY !in obstacleGrid.sizeRange || aheadX !in obstacleGrid.sizeRange) {
                break
            }
            if (obstacleGrid[aheadY, aheadX].isObstacle()) {
                direction = direction.right()
            }
            val (nextY, nextX) = move(y, x, direction)
            y = nextY
            x = nextX
        }
        return false
    }

    private fun readGrid(): ObstacleGrid {
        return ObstacleGrid(input.map { it.trim().toCharArray().toList().map { a -> ObstacleGridElement(a.toString()) } })
    }

}