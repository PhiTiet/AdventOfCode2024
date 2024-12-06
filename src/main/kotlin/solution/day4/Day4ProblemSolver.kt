package solution.day4

import solution.AbstractProblemSolver
import solution.day4.model.WordGrid
import solution.day4.model.WordGridElement

class Day4ProblemSolver : AbstractProblemSolver<Int>() {

    private val input = getProblemInput()
    private val grid =
        WordGrid(input.map { it.trim().toCharArray().toList().map { a -> WordGridElement(a.toString()) } })

    override fun partOne(): Int {
        val stringToFind = "XMAS"
        var hits = 0
        for (y in grid.sizeRange) {
            for (x in grid.sizeRange) {
                if (grid.symbolAt(y, x) != stringToFind.first().toString()) {
                    continue
                }
                val search: MutableList<String> = MutableList(8) { "" }
                for (k in 0 until stringToFind.length) {
                    search[0] += grid.symbolAt(y - k, x)           //down
                    search[1] += grid.symbolAt(y - k, x + k)    //down right
                    search[2] += grid.symbolAt(y, x + k)           //right
                    search[3] += grid.symbolAt(y + k, x + k)    //up-right
                    search[4] += grid.symbolAt(y + k, x)           //up
                    search[5] += grid.symbolAt(y + k, x - k)    //up left
                    search[6] += grid.symbolAt(y, x - k)           //left
                    search[7] += grid.symbolAt(y - k, x - k)    //down-left
                }
                hits += search.count { it == stringToFind }

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
                if (isXMASDiagonal(rightDiagonal) and isXMASDiagonal(leftDiagonal)) {
                    hits++
                }
            }
        }
        return hits
    }

    private fun isXMASDiagonal(values: String) = values.contains("M") and values.contains("S")

}