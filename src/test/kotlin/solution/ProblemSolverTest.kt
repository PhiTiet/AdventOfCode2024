package solution

import org.junit.jupiter.api.Test
import solution.day1.Day1ProblemSolver
import solution.day2.Day2ProblemSolver
import kotlin.test.assertEquals

class ProblemSolverTest {
    @Test
    fun dayOne() {
        verify(Day1ProblemSolver(), answerOne = 2066446, answerTwo = 24931009)
    }

    @Test
    fun dayTwo() {
        verify(Day2ProblemSolver(), answerOne = 686, answerTwo = 717)
    }

    private fun <A : Number> verify(solver : AbstractProblemSolver<A>, answerOne: A, answerTwo: A){
        assertEquals(answerOne, solver.partOne())
        assertEquals(answerTwo, solver.partTwo())
    }
}