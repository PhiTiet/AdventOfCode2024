package solution

import org.junit.jupiter.api.Test
import solution.day1.Day1ProblemSolver
import solution.day2.Day2ProblemSolver
import solution.day3.Day3ProblemSolver
import solution.day4.Day4ProblemSolver
import solution.day5.Day5ProblemSolver
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

    @Test
    fun dayThree() {
        verify(Day3ProblemSolver(), answerOne = 166630675, answerTwo = 93465710)
    }

    @Test
    fun dayFour() {
        verify(Day4ProblemSolver(), answerOne = 2534, answerTwo = 1866)
    }

    @Test
    fun dayFive() {
        verify(Day5ProblemSolver(), answerOne = 0, answerTwo = 0)
    }

    private fun <A : Number> verify(solver : AbstractProblemSolver<A>, answerOne: A, answerTwo: A){
        assertEquals(answerOne, solver.partOne())
        assertEquals(answerTwo, solver.partTwo())
    }
}