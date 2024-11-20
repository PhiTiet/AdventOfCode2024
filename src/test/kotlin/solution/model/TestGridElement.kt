package solution.model

class TestGridElement(symbol: String) : AbstractGridElement(symbol) {
    var type: TestType = TestType.valueOf(symbol.uppercase())
}