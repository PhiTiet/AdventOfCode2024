package solution.model


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DirectionTest {

    @Test
    fun turnRight() {
        assertEquals(Direction.NORTH.right(), Direction.EAST)
        assertEquals(Direction.EAST.right(), Direction.SOUTH)
        assertEquals(Direction.SOUTH.right(), Direction.WEST)
        assertEquals(Direction.WEST.right(), Direction.NORTH)
    }

    @Test
    fun left() {
        assertEquals(Direction.NORTH.left(), Direction.WEST)
        assertEquals(Direction.WEST.left(), Direction.SOUTH)
        assertEquals(Direction.SOUTH.left(), Direction.EAST)
        assertEquals(Direction.EAST.left(), Direction.NORTH)
    }

    @Test
    fun reverse() {
        assertEquals(Direction.NORTH.reverse(), Direction.SOUTH)
        assertEquals(Direction.EAST.reverse(), Direction.WEST)
        assertEquals(Direction.SOUTH.reverse(), Direction.NORTH)
        assertEquals(Direction.WEST.reverse(), Direction.EAST)
    }
}

