package solution.day4

import solution.AbstractProblemSolver
import solution.day4.model.WordGrid
import solution.day4.model.WordGridElement

class Day4ProblemSolver : AbstractProblemSolver<Int>() {

    private val input = getProblemInput()
    private val grid = WordGrid(input.map { it.trim().toCharArray().toList().map { a -> WordGridElement(a.toString()) } })

    override fun partOne(): Int {
        val stringToFind = "XMAS"
        var hits = 0
        for (x in grid.sizeRange) {
            for (y in grid.sizeRange) {
                if (grid.symbolAt(x, y) != stringToFind.firstLetter()) {
                    continue
                }
                val search: MutableList<String> = MutableList(8) { stringToFind.firstLetter() }
                for (k in 1 until stringToFind.length) {
                    //up
                    search[0] += grid.symbolAt(x - k, y)
                    //up-right
                    search[1] += grid.symbolAt(x - k, y + k)
                    //right
                    search[2] += grid.symbolAt(x, y + k)
                    //right-down
                    search[3] += grid.symbolAt(x + k, y + k)
                    //down
                    search[4] += grid.symbolAt(x + k, y)
                    //down-left
                    search[5] += grid.symbolAt(x + k, y - k)
                    //left
                    search[6] += grid.symbolAt(x, y - k)
                    //left-up
                    search[7] += grid.symbolAt(x - k, y - k)
                }
                hits += search.filter { it == stringToFind }.count()

            }
        }
        return hits
    }

    override fun partTwo(): Int {
        var hits = 0
        for (x in grid.sizeRange) {
            for (y in grid.sizeRange) {
                if (grid.symbolAt(x, y) != "A") {
                    continue
                }
                val rightDiagonal = grid.symbolAt(x + 1, y - 1) + grid.symbolAt(x - 1, y + 1)
                val leftDiagonal = grid.symbolAt(x - 1, y - 1) + grid.symbolAt(x + 1, y + 1)
                if (isXMASDiagonal(rightDiagonal) and isXMASDiagonal(leftDiagonal)){
                    hits++
                }
            }
        }
        return hits
    }

    private fun String.firstLetter(): String = first().toString()
    private fun isXMASDiagonal(values: String) = values.contains("M") and values.contains("S") and (values.length == 2)

}