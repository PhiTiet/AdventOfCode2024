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
        val doIndexes = matchIndexes(Regex("do\\(\\)")).toMutableList()
        val dontIndexes = matchIndexes(Regex("don't\\(\\)")).toMutableList()
        doIndexes.add(index = 0, element = 0)
        dontIndexes.add(index = dontIndexes.size, element = input.length - 1)
        val doRanges = doIndexes.map { it..dontIndexes.smallestValueWhichIsLargerThan(it) }
        val grouped = doRanges.groupBy { it.last }
        val unique = grouped.map { a -> a.value.minBy { it.first } }
        val subStrings = unique.map {  input.substring(it)}
        val result = subStrings.reduce(String::plus)
        return extractAndMultiplyCommands(result)
    }

    private fun matchIndexes(regex: Regex): List<Int> {
        return regex.findAll(input).map { it.range.first }.toList()
    }

    fun List<Int>.smallestValueWhichIsLargerThan(value: Int) = filter { it > value }.minOrNull()?: size
}