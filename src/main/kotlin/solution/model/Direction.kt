package solution.model

enum class Direction {
    NORTH, EAST, SOUTH, WEST;

    private val arrowSymbols = listOf("^", ">", "v", "<")

    fun right(): Direction {
        return values()[(ordinal + 1) % values().size]
    }

    fun left(): Direction {
        return values()[(ordinal + 3) % values().size]
    }

    fun reverse(): Direction {
        return values()[(ordinal + 2) % values().size]
    }

    fun arrowSymbolToDirection(symbol: String): Direction {
        require(arrowSymbols.contains(symbol)) { "$symbol is not a valid direction" }
        return values()[arrowSymbols.indexOf(symbol)]

    }
}
