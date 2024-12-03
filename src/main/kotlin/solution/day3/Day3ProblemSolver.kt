package solution.day3

import solution.AbstractProblemSolver

class Day3ProblemSolver: AbstractProblemSolver<Int>() {

    private val input = getProblemInput().reduce(String::plus)

    override fun partOne(): Int {
        val reg = Regex("mul\\((?<left>\\d{1,3}),(?<right>\\d{1,3})\\)")
        return reg.findAll(input)
            .toList()
            .map { a -> Pair(a.groups["left"]!!.value, a.groups["right"]!!.value) }
            .sumOf { it.first.toInt() * it.second.toInt() }
    }

    override fun partTwo(): Int {
        val dontRegex = Regex("don't\\(\\)")
        val doMatcher = Regex("do\\(\\)")
            return 0
    }
}