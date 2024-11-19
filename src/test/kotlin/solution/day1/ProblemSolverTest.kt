package solution.day1

import solution.AbstractProblemSolver
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class ProblemSolverTest {
    @Test
    fun dayOne() {
        verify(Day1ProblemSolver(), 0, 0)
    }

    private fun <A : Number> verify(solver : AbstractProblemSolver<A>, awnserOne: A, awnserTwo: A){
        assertTrue { solver.partOne() == awnserOne }
        assertTrue { solver.partTwo() == awnserTwo }
    }
}