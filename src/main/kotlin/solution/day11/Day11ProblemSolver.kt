package solution.day11

import solution.AbstractProblemSolver

class Day11ProblemSolver : AbstractProblemSolver<Long>() {

    private val input = getProblemInput(" ").map { it.toLong() }.toMutableList()
    private val memoized = mutableMapOf<Pair<Long, Long>, Long>()
    
    override fun partOne(): Long {
        return input.sumOf { count(stone = it, remainingBlinks = 25) }
    }

    override fun partTwo(): Long {
        return  input.sumOf { count(stone = it, remainingBlinks = 75) }
    }

    private fun count(stone: Long, remainingBlinks: Long): Long {
        val key = Pair(stone, remainingBlinks)
        if (key in memoized) return memoized[key]!!

        if (remainingBlinks == 0L) return 1

        val string = stone.toString()
        val result: Long

        if (stone == 0L) {
            result = count(stone = 1, remainingBlinks = remainingBlinks - 1)
        }
        else if (string.length % 2 == 0) {
            val left = string.substring(0, string.length / 2).toLong()
            val right = string.substring(string.length / 2).toLong()
            result = count(stone = left, remainingBlinks = remainingBlinks - 1) + count(right, remainingBlinks - 1)
        }
        else {
            result = count(stone = stone * 2024, remainingBlinks = remainingBlinks - 1)
        }
        memoized[key] = result
        return result
    }

}