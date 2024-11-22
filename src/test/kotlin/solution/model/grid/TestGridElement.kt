package solution.model.grid

class TestGridElement(symbol: String) : AbstractGridElement(symbol) {
    var type: TestType = TestType.valueOf(symbol.uppercase())
}