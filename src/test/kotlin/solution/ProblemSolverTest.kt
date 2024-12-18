package solution

import org.junit.jupiter.api.Test
import solution.day1.Day1ProblemSolver
import solution.day10.Day10ProblemSolver
import solution.day11.Day11ProblemSolver
import solution.day2.Day2ProblemSolver
import solution.day3.Day3ProblemSolver
import solution.day4.Day4ProblemSolver
import solution.day5.Day5ProblemSolver
import solution.day6.Day6ProblemSolver
import solution.day7.Day7ProblemSolver
import solution.day8.Day8ProblemSolver
import solution.day9.Day9ProblemSolver
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
        verify(Day5ProblemSolver(), answerOne = 6242, answerTwo = 5169)
    }

    @Test
    fun daySix() {
        verify(Day6ProblemSolver(), answerOne = 4977, answerTwo = 1729)
    }

    @Test
    fun daySeven(){
        verify(Day7ProblemSolver(), answerOne = 4998764814652L, answerTwo = 37598910447546L)
    }
    @Test
    fun dayEight(){
        verify(Day8ProblemSolver(), answerOne = 398, answerTwo = 1333)
    }

    @Test
    fun dayNine(){
        verify(Day9ProblemSolver(), answerOne = 6446899523367, answerTwo = 6478232739671)
    }
    @Test
    fun dayTen(){
        verify(Day10ProblemSolver(), answerOne = 629, answerTwo = 1242)
    }

    @Test
    fun dayEleven(){
        verify(Day11ProblemSolver(), answerOne = 216996, answerTwo = 257335372288947)
    }

    private fun <A : Number> verify(solver : AbstractProblemSolver<A>, answerOne: A, answerTwo: A){
        assertEquals(answerOne, solver.partOne())
        assertEquals(answerTwo, solver.partTwo())
    }
}