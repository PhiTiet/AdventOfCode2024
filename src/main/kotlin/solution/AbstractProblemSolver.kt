package solution

import java.io.FileNotFoundException

abstract class AbstractProblemSolver<A: Number> : ProblemSolver<A> {
    protected fun getInput() : List<String>{
        return this::class.java.getResourceAsStream(inputPath())?.bufferedReader()?.readLines() ?: throw FileNotFoundException("file does not exist")
    }

    private fun inputPath(): String{
        return "/solutions/${dayNumberFromClass()}.txt"
    }

    private fun dayNumberFromClass(): String {
        return Regex("Day\\d+").find(this.javaClass.simpleName)?.value?.lowercase()
            ?: throw IllegalArgumentException("input not found")
    }

}