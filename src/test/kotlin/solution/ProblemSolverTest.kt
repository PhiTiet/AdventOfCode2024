package solution

import org.junit.jupiter.api.Test
import solution.day1.Day1ProblemSolver
import kotlin.test.assertEquals

class ProblemSolverTest {
    @Test
    fun dayOne() {
        verify(Day1ProblemSolver(), answerOne = 2066446, answerTwo = 24931009)
    }

    private fun <A : Number> verify(solver : AbstractProblemSolver<A>, answerOne: A, answerTwo: A){
        assertEquals(answerOne, solver.partOne())
        assertEquals(answerTwo, solver.partTwo())
    }
}