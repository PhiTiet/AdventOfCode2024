package solution.day10

import solution.AbstractProblemSolver
import solution.day10.model.TopographyGrid
import solution.day10.model.TopographyGridElement
import solution.model.Direction

class Day10ProblemSolver : AbstractProblemSolver<Int>() {
    private val grid = TopographyGrid(getProblemInput().map { it.trim().toCharArray().toList().map { a -> TopographyGridElement(a.toString()) } })

    override fun partOne(): Int {
        return startIndexes().sumOf { countRoutes(it, false) }
    }

    override fun partTwo(): Int {
        return startIndexes().sumOf { countRoutes(it, true) }
    }

    private fun startIndexes(): List<Pair<Int, Int>> {
        return grid.allIndexesWhere { it.height == 0 }
    }

    private fun countRoutes(startIndex: Pair<Int, Int>, uniquePaths: Boolean): Int {
        var currentSteps = mutableListOf(startIndex)
        var trailheads = 0

        while (currentSteps.isNotEmpty()) {
            var nextSteps: MutableList<Pair<Int, Int>> = mutableListOf()
            currentSteps.forEach {  nextSteps.addAll(validNextSteps(it)) }

            if (!uniquePaths) {
                nextSteps = nextSteps.distinct().toMutableList()
            }
            trailheads += nextSteps.count { grid[it].height == 9 }
            currentSteps = nextSteps
        }
        return trailheads
    }

    private fun validNextSteps(current: Pair<Int, Int>): List<Pair<Int, Int>> {
        return Direction.values()
            .map { Direction.move(current.first, current.second, it) }
            .filter { grid.isInRange(it) && grid[it].height == grid[current].height + 1 }
    }
}