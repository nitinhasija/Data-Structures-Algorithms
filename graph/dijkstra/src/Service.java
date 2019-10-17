import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Service {

    private ArrayList<ArrayList<Node>> edgeList;

    public Service(int vertices) {
        edgeList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            edgeList.add(new ArrayList());
        }
    }

    public void initialize(PriorityQueue<Node> priorityQueue, HashMap<Integer, Node> pqMap) {
        Node node;
        for (int i = 0; i < edgeList.size(); i++) {
            if (i == 0)                              // As we want to start with first node
                node = new Node(i, 0);
            else
                node = new Node(i, Integer.MAX_VALUE);

            priorityQueue.add(node);
            pqMap.put(i, node);
        }
    }

    public void addEdge(int source, int destination, int weight) {
        edgeList.get(source - 1).add(new Node(destination - 1, weight));
        edgeList.get(destination - 1).add(new Node(source - 1, weight));
    }

    public HashMap<Integer, Integer> getShortestDistance() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getVertex));
        HashMap<Integer, Node> pqMap = new HashMap();
        HashMap<Integer, Integer> result = new HashMap();

        initialize(priorityQueue, pqMap);

        while (!priorityQueue.isEmpty()) {
            Node n = priorityQueue.remove();
            pqMap.remove(n);

            result.put(n.getVertex(), n.getWeight());

            for (Node neighbour : edgeList.get(n.getVertex())) {
                if (pqMap.containsKey(neighbour.getVertex()) && pqMap.get(neighbour.getVertex()).getWeight() > n.getWeight() + neighbour.getWeight()) {
                    Node temp = new Node(neighbour.getVertex(), n.getWeight() + neighbour.getWeight());
                    priorityQueue.remove(pqMap.get(neighbour.getVertex()));
                    priorityQueue.add(temp);
                    pqMap.put(neighbour.getVertex(), temp);
                }
            }
        }
        return result;
    }
}
