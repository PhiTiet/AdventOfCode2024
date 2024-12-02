package solution.day2

import solution.AbstractProblemSolver
import kotlin.math.abs
import kotlin.math.sign

class Day2ProblemSolver : AbstractProblemSolver<Int>() {

    val input = getPuzzleInput()

    override fun partOne(): Int {
        val reports: List<List<Int>> = input.map { it.split(" ").map { it.toInt() } }
        return reports
            .map { it.zipWithNext { a, b -> a - b } }
            .map { isValidDifference(it) }
            .count { it }
    }

    private fun isValidDifference(report: List<Int>): Boolean {
        return report.all { abs(it) in 1..3 } and (report.distinctBy { it.sign }.size == 1)
    }

    override fun partTwo(): Int {
        val listNumber: List<List<Int>> = input.map { it.split(" ").map { it.toInt() } }
        return 0
    }

}