package solution.day9.model

class DiskMap(input: String) {
    private val segments: MutableList<DiskSegment> = mutableListOf()

    init {
        var index = 0
        for (i in input.indices) {
            if (i % 2 == 0){
                segments.add(DiskSegmentFilled(index, input[i].digitToInt()))
                index++
            }
            else {
                segments.add(DiskSegmentEmpty(input[i].digitToInt()))
            }
        }
    }
}