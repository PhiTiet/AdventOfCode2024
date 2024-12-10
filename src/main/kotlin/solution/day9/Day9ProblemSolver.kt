package solution.day9

import solution.AbstractProblemSolver
import solution.day9.model.DiskMap

class Day9ProblemSolver :AbstractProblemSolver<Long>() {

    private var diskMap = DiskMap(getProblemInput().first())

    override fun partOne(): Long {
        diskMap.partition()
        return diskMap.checksum()
    }

    override fun partTwo(): Long {
        diskMap = DiskMap(getProblemInput().first())
        diskMap.partitionFullSegments()
        return diskMap.checksum()
    }
}