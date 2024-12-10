package solution.day9.model

class DiskMap(input: String) {
    private var segments: MutableList<DiskSegment> = mutableListOf()


    override fun toString(): String{
        var ret = ""
        for (segment in segments){
            ret += segment.toString()
        }
        return ret
    }

    fun partition() {
        var operation: Boolean
        do {
            operation = false
            segments = segments.filter { it.size != 0 }.toMutableList()
            val firstEmptyIndex = segments.indexOfFirst { it is DiskSegmentEmpty && it.size > 0 }
            val lastFilledIndex = segments.indexOfLast { it is DiskSegmentFilled && it.size > 0 }

            if (firstEmptyIndex < lastFilledIndex){
                operation = true
                val lastFilled = segments[lastFilledIndex] as DiskSegmentFilled
                val firstEmpty = segments[firstEmptyIndex] as DiskSegmentEmpty
                firstEmpty.size--
                lastFilled.size--

                segments.add(lastFilledIndex + 1, DiskSegmentEmpty(size = 1))
                segments.add(firstEmptyIndex, DiskSegmentFilled(lastFilled.id, 1))
            }

        } while (operation)

    }

    fun partitionFullSegments(){
        for (i in segments.indices.reversed()){
            if (segments[i] is DiskSegmentFilled){
                val current = segments[i] as DiskSegmentFilled
                val firstIndexFitting = segments.indexOfFirst { it is DiskSegmentEmpty && it.size >= current.size }
                if (firstIndexFitting < 0){
                    continue
                }
                if (firstIndexFitting < i){
                    val empty = segments[firstIndexFitting] as DiskSegmentEmpty
                    empty.size -= current.size
                    segments[i] = DiskSegmentEmpty(current.size)
                    segments.add(firstIndexFitting, current)
                }
            }
        }
    }

    fun checksum(): Long {
        var result = 0L
        var stringIndex = 0
        for (i in segments.indices) {
            if (segments[i] is DiskSegmentEmpty) {
                stringIndex += segments[i].size
                continue
            }
            val current = segments[i] as DiskSegmentFilled
            for (j in 0 until current.size){
                result += current.id * stringIndex
                stringIndex++
            }
        }
        return result
    }


    init {
        var index = 0L
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