package solution.day7

import solution.AbstractProblemSolver
import solution.day7.model.Equation

class Day7ProblemSolver: AbstractProblemSolver<Long>() {

    private val equations = getProblemInput().map {
        Equation(it.split(": ")[0].toLong(), it.split(": ")[1].split(" ").map { it.toLong() })
    }

    override fun partOne(): Long {
        return equations.filter { it.hasSolution(listOf("+", "*")) }.sumOf { it.result }
    }

    override fun partTwo(): Long {
        return equations.filter { it.hasSolution(listOf("+", "*", "||")) }.sumOf { it.result }

        return 0
    }
}