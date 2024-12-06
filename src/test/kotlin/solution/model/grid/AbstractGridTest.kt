package solution.model.grid

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AbstractGridTest {
    private var elements: MutableList<MutableList<TestGridElement>>

    init {
        val strings = listOf(listOf("a", "b", "a"), listOf("b", "a", "b"), listOf("a", "b", "a"))
        elements = strings.map { it.map { a -> TestGridElement(a) }.toMutableList() }.toMutableList()
    }

    @Test
    fun constructs() {
        val grid = TestGrid(elements)
        grid.displayGrid()
    }

    @Test
    fun mustBeSquare() {
        val strings = listOf(listOf("a", "b", "a"), listOf("b", "a", "b"))
        val elements = strings.map { it.map { a -> TestGridElement(a) }.toMutableList() }.toMutableList()
        assertThrows<IllegalArgumentException> { TestGrid(elements) }
    }

    @Test
    fun mustNotBeEmpty() {
        assertThrows<IllegalArgumentException> { TestGrid(mutableListOf()) }
    }

    @Test
    fun accessedCorrectly() {
        val grid = TestGrid(elements)
        assertThat(grid[0, 0].type).isEqualTo(TestType.A)
    }


    @Test
    fun accessedOutOfBounds() {
        val grid = TestGrid(elements)
        assertThrows<IllegalArgumentException> { grid[grid.size, grid.size] }
    }
}