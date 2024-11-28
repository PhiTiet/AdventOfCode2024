package solution.model.graph

class Graph<N>(
    val vertices: Set<N>,
    val edges: Map<N, Set<N>>,
    val weights: Map<Pair<N, N>, Int>
) {

    fun shortestPath(start: N, end: N) {
        var shortestPathTree = emptySet<N>()
        var distancesToStart = vertices.associateWith { a -> Int.MAX_VALUE }.toMutableMap()

        distancesToStart[start] = 0
        while (!shortestPathTree.containsAll(vertices)) {

            val (current: N, distance: Int) =
                distancesToStart.entries
                .filter { k -> !shortestPathTree.contains(k.key) }
                .minBy { k -> distancesToStart[k.key]!! }
            shortestPathTree = shortestPathTree.plus(current)

            for (adjacent in edges[current]!!) {
                val newDistance = distance + weights[Pair(current, adjacent)]!!
                if (distancesToStart[adjacent]!! > newDistance) {
                    distancesToStart[adjacent] = newDistance
                }
            }

        }
    }

}

