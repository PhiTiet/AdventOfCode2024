package solution.day4

import solution.AbstractProblemSolver
import solution.day4.model.WordGrid
import solution.day4.model.WordGridElement

class Day4ProblemSolver : AbstractProblemSolver<Int>() {

    val input = getProblemInput()

    val grid = WordGrid(input.map { it.trim().toCharArray().toList().map { a ->  WordGridElement(a.toString()) } })

    override fun partOne(): Int {
        val stringToFind = "XMAS"
        var hits = 0
        for (x in grid.sizeRange) {
            for (y in grid.sizeRange) {
                if (grid[x, y].symbol != stringToFind.firstLetter()) {
                    continue
                }
                val search: MutableList<String> = MutableList(8) { stringToFind.firstLetter() }
                for (k in 1 until stringToFind.length) {
                    //up
                    search[0] += grid[x - k, y].symbol
                    //up-right
                    search[1] += grid[x - k, y + k].symbol
                    //right
                    search[2] += grid[x, y + k].symbol
                    //right-down
                    search[3] += grid[x + k, y + k].symbol
                    //down
                    search[4] += grid[x + k, y].symbol
                    //down-left
                    search[5] += grid[x + k, y - k].symbol
                    //left
                    search[6] += grid[x, y - k].symbol
                    //left-up
                    search[7] += grid[x - k, y - k].symbol
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
                if (grid[x, y].symbol != "A") {
                    continue
                }
                val rightDiagonal = grid[x + 1, y - 1].symbol + grid[x - 1, y + 1].symbol
                val leftDiagonal = grid[x - 1, y - 1].symbol + grid[x + 1, y + 1].symbol
                if (isXMASDiagonal(rightDiagonal) and isXMASDiagonal(leftDiagonal)){
                    hits++
                }
            }
        }
        return hits
    }

    private fun String.firstLetter(): String = first().toString()
    private fun isXMASDiagonal(values: String) : Boolean{
        return values.contains("M") and values.contains("S") and (values.length == 2)
    }
}