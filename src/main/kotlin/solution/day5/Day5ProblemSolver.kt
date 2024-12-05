package solution.day5

import solution.AbstractProblemSolver
import solution.day5.model.PageRule
import kotlin.collections.map

class Day5ProblemSolver : AbstractProblemSolver<Int>() {
    private val input = getProblemInput("\n\n")
    private var rules = input[0].split("\n").map { PageRule(it.split("|")[0].toInt(), it.split("|")[1].toInt()) }
    private val pages = input[1].split("\n").map { it.split(",").map { it.toInt() } }

    override fun partOne(): Int {
        return pages
            .filter { isValidPage(it) }
            .map { it[it.size / 2] }
            .sum()
    }

    override fun partTwo(): Int {
        return pages.filter { !isValidPage(it) }.map { it.toMutableList() }
            .map { reorderUsingRules(it) }
            .map { it[it.size / 2] }
            .sum()
    }

    private fun isValidPage(page: List<Int>): Boolean {
        return rules.map { ruleApplies(page, it) }.all { it }
    }

    fun ruleApplies(list: List<Int>, pageRule: PageRule): Boolean {
        val firstIndex = list.indexOfLast { it == pageRule.before }
        val secondIndex = list.indexOfFirst { it == pageRule.after }

        return firstIndex == -1 || secondIndex == -1 || firstIndex < secondIndex
    }


    fun reorderUsingRules(pages: MutableList<Int>): MutableList<Int> {
        var ret = pages
        while (!isValidPage(ret)) {
            rules = rules.shuffled()
            rules.forEach { ret = moveItem(ret, it) }
        }

        return ret
    }

    fun moveItem(pages: MutableList<Int>, pageRule: PageRule): MutableList<Int> {
        val fromIndex = pages.lastIndexOf(pageRule.before)
        val toIndex = pages.indexOf(pageRule.after)

        if (fromIndex == -1 || toIndex == -1 || fromIndex < toIndex) {
            return pages
        }

        pages.add(toIndex, pages.removeAt(fromIndex))
        return pages
    }

}