package solution.day1

import solution.AbstractProblemSolver
import kotlin.math.abs

class Day1ProblemSolver : AbstractProblemSolver<Int>() {

    private val input = getInput()

    override fun partOne(): Int {
        var leftList : MutableList<Int>  = mutableListOf()
        var rightList : MutableList<Int>  = mutableListOf()

        input.forEach {
            val (left, right) = it.split("   ")
            leftList.add(left.toInt())
            rightList.add(right.toInt())
        }

        leftList.sort()
        rightList.sort()

        return leftList.mapIndexed { i, v -> abs(v - rightList[i]) }.sum()
    }

    override fun partTwo(): Int {
        var leftSet : MutableSet<Int>  = mutableSetOf()
        var rightList : MutableList<Int>  = mutableListOf()

        input.forEach {
            val (left, right) = it.split("   ")
            leftSet.add(left.toInt())
            rightList.add(right.toInt())
        }
        val map: Map<Int, Int> = rightList.groupBy{it}.mapValues{it.value.size}

        return  leftSet.map {it * map.getOrDefault(it, 0) }.sum()
    }
}