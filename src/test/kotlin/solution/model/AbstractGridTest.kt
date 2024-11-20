package solution.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AbstractGridTest {
    private var elements: List<List<TestGridElement>>

    init {
        val strings = listOf(listOf("a", "b", "a"), listOf("b", "a", "b"), listOf("a", "b", "a"))
        elements = strings.map { it.map { a -> TestGridElement(a) } }.toList()
    }

    @Test
    fun constructs() {
        val grid = TestGrid(elements)
        grid.displayGrid()
    }

    @Test
    fun mustBeSquare() {
        val strings = listOf(listOf("a", "b", "a"), listOf("b", "a", "b"))
        val elements = strings.map { it.map { a -> TestGridElement(a) } }.toList()
        assertThrows<IllegalArgumentException> { TestGrid(elements) }
    }

    @Test
    fun mustNotBeEmpty() {
        assertThrows<IllegalArgumentException> { TestGrid(emptyList()) }
    }

    @Test
    fun accessedCorrectly() {
        val grid = TestGrid(elements)
        assertThat(grid.getElement(0, 0).type).isEqualTo(TestType.A)
    }


    @Test
    fun accessedOutOfBounds() {
        val grid = TestGrid(elements)
        assertThrows<IllegalArgumentException>{ grid.getElement(grid.size, grid.size) }
    }
}