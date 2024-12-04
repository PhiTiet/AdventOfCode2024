package solution.day4

import solution.AbstractProblemSolver
import solution.day4.model.WordGrid
import solution.day4.model.WordGridElement

class Day4ProblemSolver : AbstractProblemSolver<Int>() {

    val input = getProblemInput()

    val grid = WordGrid(input.map { it.trim().toCharArray().toList().map { WordGridElement(it.toString()) } })

    override fun partOne(): Int {
        grid.displayGrid()
        return 0
    }

    override fun partTwo(): Int {
        return 0
    }
}