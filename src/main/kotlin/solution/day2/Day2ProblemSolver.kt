package solution.day2

import solution.AbstractProblemSolver
import kotlin.collections.zipWithNext
import kotlin.math.abs
import kotlin.math.sign

class Day2ProblemSolver : AbstractProblemSolver<Int>() {

    val reports = getProblemInput().map { it.split(" ").map { it.toInt() } }

    override fun partOne(): Int {
        return reports
            .map { isValidReport(it) }
            .count { it }
    }

    override fun partTwo(): Int {
        return reports
            .map { hasAtLeastOneValidSubset(it) }
            .count { it }
    }

    private fun isValidReport(report: List<Int>): Boolean {
        val differences = report.zipWithNext { a, b -> a - b }
        return differences.all { abs(it) in 1..3 } and (differences.distinctBy { it.sign }.size == 1)
    }

    private fun hasAtLeastOneValidSubset(report: List<Int>): Boolean {
        return report
            .mapIndexed { i, _ -> report.withoutItemAt(i) }
            .any { isValidReport(it) }
    }

    fun List<Int>.withoutItemAt(index: Int) = filterIndexed { i, _ -> i != index }

}