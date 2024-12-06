package solution.model

enum class Direction {
    NORTH, EAST, SOUTH, WEST;



    fun right(): Direction {
        return values()[(ordinal + 1) % values().size]
    }

    fun left(): Direction {
        return values()[(ordinal + 3) % values().size]
    }

    fun reverse(): Direction {
        return values()[(ordinal + 2) % values().size]
    }

    companion object {
        private val arrowSymbols = listOf("^", ">", "v", "<")
        fun toDirection(symbol: String): Direction {
            require(arrowSymbols.contains(symbol)) { "$symbol is not a valid direction" }
            return values()[arrowSymbols.indexOf(symbol)]

        }

        fun move(y: Int, x: Int, direction: Direction): Pair<Int, Int> {
            return when (direction) {
                NORTH -> Pair(y + 1, x)
                EAST -> Pair(y, x + 1)
                SOUTH -> Pair(y - 1, x)
                WEST -> Pair(y, x - 1)
            }
        }
    }
}
