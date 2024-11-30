package solution

import client.AOCClient


abstract class AbstractProblemSolver<A : Number> : ProblemSolver<A> {

    protected fun getInput(): List<String> {
        return AOCClient().getInput(dayNumberFromClass())
    }

    private fun dayNumberFromClass(): Int {
        return (Regex("Day(\\d+)")
            .find(this.javaClass.simpleName)
            ?.groupValues?.get(1)?.toInt()
            ?: throw IllegalArgumentException("Day number not found"))
    }
}


