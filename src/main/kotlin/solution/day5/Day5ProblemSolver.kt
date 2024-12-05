package solution.day5

import solution.AbstractProblemSolver
import solution.day5.model.PageRule

class Day5ProblemSolver: AbstractProblemSolver<Int>() {
    private val input = getProblemInput("\n\n")

    override fun partOne(): Int {
        val rules = input[0].split("\n").map { PageRule(it.split("|")[0].toInt(),it.split("|")[1].toInt() ) }
        val pages = input[1].split("\n").map { it.split(",") }
        return 0
    }

    override fun partTwo(): Int {
        return 0
    }

    private fun isValidPage(page: List<Int>): Boolean {
        return false
    }
}