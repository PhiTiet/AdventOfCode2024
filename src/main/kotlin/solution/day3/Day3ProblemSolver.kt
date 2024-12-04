package solution.day3

import solution.AbstractProblemSolver

class Day3ProblemSolver: AbstractProblemSolver<Int>() {

    private val input = getProblemInput().reduce(String::plus)

    override fun partOne(): Int {
        return extractAndMultiplyCommands(input)
    }

    private fun extractAndMultiplyCommands(command: String) =
        Regex("mul\\((?<left>\\d{1,3}),(?<right>\\d{1,3})\\)").findAll(command)
            .toList()
            .map { a -> Pair(a.groups["left"]!!.value, a.groups["right"]!!.value) }
            .sumOf { it.first.toInt() * it.second.toInt() }

    override fun partTwo(): Int {
        val extractedCommand = extractRelevantCommandSegments()
        return extractAndMultiplyCommands(extractedCommand)
    }

    private fun extractRelevantCommandSegments(): String {
        val doIndexes = listOf(0) + matchIndexes(Regex("do\\(\\)"))
        val dontIndexes = matchIndexes(Regex("don't\\(\\)")) + listOf(input.length - 1)
        return doIndexes
            .map { doIndex -> doIndex until dontIndexes.filter { it > doIndex }.min() }
            .groupBy { it.last }
            .map { a -> a.value.minBy { it.first } }
            .map { input.substring(it) }
            .reduce(String::plus)
    }

    private fun matchIndexes(regex: Regex): List<Int> {
        return regex.findAll(input).map { it.range.first }.toList()
    }

}