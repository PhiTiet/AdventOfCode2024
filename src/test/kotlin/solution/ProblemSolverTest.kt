package solution

import org.junit.jupiter.api.Test
import solution.day1.Day1ProblemSolver
import kotlin.test.assertTrue

class ProblemSolverTest {
    @Test
    fun dayOne() {
        verify(Day1ProblemSolver(), answerOne = 0, answerTwo = 0)
    }

    private fun <A : Number> verify(solver : AbstractProblemSolver<A>, answerOne: A, answerTwo: A){
        assertTrue { solver.partOne() == answerOne }
        assertTrue { solver.partTwo() == answerTwo }
    }
}