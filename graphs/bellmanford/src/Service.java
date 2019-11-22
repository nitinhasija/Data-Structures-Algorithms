import java.util.ArrayList;
import java.util.HashMap;

public class Service {
    private ArrayList<Graph> list;
    private int vertex;

    public Service(int vertex) {
        this.vertex = vertex;
        list = new ArrayList<>();
    }

    public void addEdge(int source, int destination, int weight) {
        list.add(new Graph(source, destination, weight));
    }

    private void initialize(HashMap<Integer, Integer> hashMap) {

        for (int i = 0; i < vertex; i++) {
            if (i == 0)                              // As we want to start with first node
                hashMap.put(i, 0);
            else
                hashMap.put(i, 100000);
        }
    }

    public HashMap<Integer, Integer> getShortestPath() {
        HashMap<Integer, Integer> result = new HashMap<>();
        initialize(result);

        boolean isNegativeWeightCycle = false;

        for (int i = 0; i < vertex; i++) {
            for (Graph graph : list) {
                int source = graph.getSource();
                int destination = graph.getDestination();
                int weight = graph.getWeight();

                if (result.get(destination) > (result.get(source) + weight)) {
                    result.put(destination, result.get(source) + weight);
                    isNegativeWeightCycle = (i == vertex - 1) ? true : false;
                }
            }
        }

        return isNegativeWeightCycle ? null : result;
    }
}
