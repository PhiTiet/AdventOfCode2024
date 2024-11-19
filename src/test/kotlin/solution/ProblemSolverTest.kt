package solution

import org.junit.jupiter.api.Test
import solution.day1.Day1ProblemSolver
import kotlin.test.assertTrue

class ProblemSolverTest {
    @Test
    fun dayOne() {
        verify(Day1ProblemSolver(), awnserOne = 0, awnserTwo = 0)
    }

    private fun <A : Number> verify(solver : AbstractProblemSolver<A>, awnserOne: A, awnserTwo: A){
        assertTrue { solver.partOne() == awnserOne }
        assertTrue { solver.partTwo() == awnserTwo }
    }
}