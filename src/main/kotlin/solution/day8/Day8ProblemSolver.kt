package solution.day8

import solution.AbstractProblemSolver
import solution.day8.model.AntennaGrid
import solution.day8.model.AntennaGridElement

class Day8ProblemSolver : AbstractProblemSolver<Int>() {
    private val input = getProblemInput()
    private val grid = AntennaGrid(input.map { it.trim().toCharArray().toList().map { a -> AntennaGridElement(a.toString()) } })


    override fun partOne(): Int {
        grid
            .allIndexesWhere { it.isAntenna() }
            .forEach { markAntiNodes(it) }
        return grid.count { it.isAntiNode }
    }

    override fun partTwo(): Int {
        grid
            .allIndexesWhere { it.isAntenna() }
            .forEach { markAdvancedAntiNodes(it) }
        return grid.count { it.isAntiNode or it.isAntenna() }
    }

    private fun markAntiNodes(coordinates: Pair<Int, Int>) {
        val current = grid[coordinates.first, coordinates.second]
        val similarAntennas = grid.allIndexesWhere { it.symbol == current.symbol }.minus(coordinates)
        similarAntennas.forEach {
            val antiAntennaY = coordinates.first + (coordinates.first - it.first)
            val antiAntennaX = coordinates.second + (coordinates.second - it.second)
            if (antiAntennaX in grid.sizeRange && antiAntennaY in grid.sizeRange){
                    grid[antiAntennaY,antiAntennaX].isAntiNode = true
            }
        }
    }
    private  fun markAdvancedAntiNodes(coordinates: Pair<Int, Int>) {
        val current = grid[coordinates.first, coordinates.second]
        val similarAntennas = grid.allIndexesWhere { it.symbol == current.symbol }.minus(coordinates)

        similarAntennas.forEach {
            val diffY = coordinates.first - it.first
            val diffX = coordinates.second - it.second
            var antiAntennaY = coordinates.first
            var antiAntennaX = coordinates.second

            while (antiAntennaY + diffY in grid.sizeRange && antiAntennaX + diffX in grid.sizeRange){
                antiAntennaY += diffY
                antiAntennaX += diffX
                grid[antiAntennaY,antiAntennaX].isAntiNode = true
            }
        }

    }


}