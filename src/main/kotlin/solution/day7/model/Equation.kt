package solution.day7.model

class Equation(val result: Long, val operands: List<Long>) {

    fun hasSolution(operators: List<String>): Boolean {
        val sequences = allSequences(operators, operands.size - 1)
        return sequences.map { applySequence(it, operands) }.contains(result)
    }

    private fun applySequence(sequence: List<String>, operands: List<Long>): Long {
        var result = operands.first()
        for (i in 0..operands.size - 2) {
            if (sequence[i] == "*") {
                result *= operands[i + 1]
            } else if (sequence[i] == "+") {
                result += operands[i + 1]
            } else if (sequence[i] == "||") {
                result = stringConcatenate(result, operands[i + 1])
            }
        }
        return result

    }

    private fun stringConcatenate(a: Long, b: Long): Long {
        return (a.toString() + b.toString()).toLong()
    }

    private fun allSequences(elements: List<String>, size: Int): List<List<String>> {
        if (size == 0) return listOf(emptyList())
        val smallerLists = allSequences(elements, size - 1)
        return smallerLists.flatMap { smallerList ->
            elements.map { element -> smallerList + element }
        }
    }
}