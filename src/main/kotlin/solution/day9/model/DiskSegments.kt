package solution.day9.model

abstract class DiskSegment(private val size: Int)

data class DiskSegmentFilled(private val id: Int, private val size: Int) : DiskSegment(size)

data class DiskSegmentEmpty(private val size: Int) : DiskSegment(size)