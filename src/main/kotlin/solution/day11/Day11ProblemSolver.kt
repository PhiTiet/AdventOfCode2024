package solution.day11

import solution.AbstractProblemSolver

class Day11ProblemSolver : AbstractProblemSolver<Long>() {

    private val input = getProblemInput(" ").map { it.toLong() }.toMutableList()
    private val memoized = mutableMapOf<Pair<Long, Long>, Long>()
    
    override fun partOne(): Long {
        var current = input

        for (i in 0 until 25) {
            var newList: MutableList<Long> = mutableListOf()
            for (stone in current) {
                newList.addAll(newStones(stone))
            }
            current = newList
        }
        return current.size.toLong()
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

    private fun newStones(num:Long): List<Long>{
        return if (num == 0L) {
            mutableListOf(1)
        } else if (num.toString().length % 2 == 0) {
            val numString = num.toString()
            val left = numString.substring(0, numString.length / 2).toLong()
            val right = numString.substring(numString.length / 2).toLong()
            listOf(left, right)
        } else {
            mutableListOf(num * 2024)
        }
    }

}