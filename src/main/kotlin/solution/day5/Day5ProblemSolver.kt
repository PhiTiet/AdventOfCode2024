package solution.day5

import solution.AbstractProblemSolver
import solution.day5.model.PageRule

class Day5ProblemSolver : AbstractProblemSolver<Int>() {
    private val input = getProblemInput("\n\n")
    private val rules = input[0].split("\n").map { PageRule(it.split("|")[0].toInt(), it.split("|")[1].toInt()) }
    private val pages = input[1].split("\n").map { it.split(",").map { it.toInt() } }

    override fun partOne(): Int {
        return pages
            .filter { isValidPage(it) }
            .map { it[it.size/2] }
            .sum()
    }

    override fun partTwo(): Int {
        return 0
    }

    private fun isValidPage(page: List<Int>): Boolean {
        return rules.map { allBefore(page, it) }.all { it }
    }

    fun allBefore(list: List<Int>, pageRule: PageRule): Boolean {
        val firstIndex = list.indexOfLast { it == pageRule.before }
        val secondIndex = list.indexOfFirst { it == pageRule.after }

        return firstIndex == -1 || secondIndex == -1 || firstIndex < secondIndex
    }
}