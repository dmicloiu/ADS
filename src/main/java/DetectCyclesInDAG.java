import java.util.List;

public class DetectCyclesInDAG {

    /**
     * Detects cycles in a connected component.
     *
     * @param s        starting vertex in our connected component.
     * @param vertices the vertex that belong to our graph.
     * @return true iff there is a cycle in the connected component the source belongs to.
     */
    public static boolean detectCycle(Vertex s, List<Vertex> vertices) {
        int[] visited = new int[vertices.size()];
        return detectCycleHelper(s, vertices.size(), visited);
    }

    public static boolean detectCycleHelper(Vertex s, int size, int[] visited) {
        if (visited[s.getId() % size] > 1) {
            return true;
        }
        visited[s.getId() % size]++;
        //System.out.println(s.getId());
        List<Vertex> outgoingEdges = s.getOutgoingEdges();

        for (Vertex next : outgoingEdges) {
            if (detectCycleHelper(next, size, visited)) {
                return true;
            }
        }
        return false;
    }

}
