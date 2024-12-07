package solution.day7.model

class Equation(val result: Long, val operands: List<Long>) {

    fun hasSolution(operators: List<String>): Boolean {
        return operatorCombinations(operators, operands.size - 1)
            .map { applySequence(it, operands) }
            .any { it == result }
    }

    private fun applySequence(sequence: List<String>, operands: List<Long>): Long {
        var result = operands.first()
        for (i in 0..operands.size - 2) {
            if (sequence[i] == "*") {
                result *= operands[i + 1]
            }
            else if (sequence[i] == "+") {
                result += operands[i + 1]
            }
            else if (sequence[i] == "||") {
                result = result concat operands[i + 1]
            }
        }
        return result

    }

    private infix fun Long.concat(other: Long): Long {
        return (this.toString() + other.toString()).toLong()
    }

    private fun operatorCombinations(operators: List<String>, size: Int): List<List<String>> {
        if (size == 0) return listOf(emptyList())
        val smallerLists = operatorCombinations(operators, size - 1)
        return smallerLists.flatMap { smallerList ->
            operators.map { element -> smallerList + element }
        }
    }

}