package solution.model

enum class Direction {
    NORTH, EAST, SOUTH, WEST;


    fun right(): Direction {
        val values = values()
        return values[(ordinal + 1) % values.size]
    }

    fun left(): Direction {
        val values = values()
        return values[(ordinal - 1 + values.size) % values.size]
    }

    fun reverse(): Direction {
        val values = values()
        return values[(ordinal + 2) % values.size]
    }
}
