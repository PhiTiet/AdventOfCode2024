package solution.day9.model

abstract class DiskSegment(open var size: Int)

data class DiskSegmentFilled(val id: Long, override var size: Int) : DiskSegment(size) {
    override fun toString(): String {
        return id.toString().repeat(size)
    }
}

data class DiskSegmentEmpty(override var size: Int) : DiskSegment(size) {
    override fun toString(): String {
        return ".".repeat(size)
    }
}

