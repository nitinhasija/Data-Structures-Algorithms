import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Service {
    private ArrayList<Edge> edgesList;
    private DisjointSet disjointSet;

    public Service() {
        edgesList = new ArrayList<>();
        disjointSet = new DisjointSet();
    }

    public void addEdge(int source, int destination, int weight) {
        disjointSet.makeSet(source - 1);
        disjointSet.makeSet(destination - 1);

        edgesList.add(new Edge(source - 1, destination - 1, weight));
    }

    public void printMinimalSpanningTree() {
        edgesList.sort(Comparator.comparingInt(Edge::getWeight));

        HashSet<Edge> hs = new HashSet<>();

        for (Edge edge : edgesList) {
            if (disjointSet.findSet(edge.getSource()) != disjointSet.findSet(edge.getDestination())) {
                disjointSet.union(edge.getSource(), edge.getDestination());
                hs.add(edge);
            }
        }

        for (Edge edge : hs) {
            System.out.println(edge);
        }
    }
}
