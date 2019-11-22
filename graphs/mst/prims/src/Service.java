import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Service {
    private ArrayList<ArrayList<Node>> edgeList;

    private void initializeTreeMap(PriorityQueue<Node> pq, HashMap<Integer, Node> priorityQueueMap) {
        Node node;
        for (int i = 0; i < edgeList.size(); i++) {
            if (i == 0)                              // As we want to start with first node
                node = new Node(i, 0);
            else
                node = new Node(i, Integer.MAX_VALUE);

            pq.add(node);
            priorityQueueMap.put(i, node);
        }
    }

    public Service(int numberOfNodes) {
        edgeList = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            edgeList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        edgeList.get(source - 1).add(new Node(destination - 1, weight));
        edgeList.get(destination - 1).add(new Node(source - 1, weight));
    }

    public HashMap<Integer, Integer> getMinimalSpanningTree() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));    // Min-Heap on the bases of weight
        HashMap<Integer, Node> priorityQueueMap = new HashMap();
        HashMap<Integer, Node> hashMap = new HashMap<>();

        HashMap<Integer, Integer> result = new HashMap<>();

        initializeTreeMap(pq, priorityQueueMap);

        while (!pq.isEmpty()) {
            Node node = pq.remove();
            priorityQueueMap.remove(node.getVertex());

            if (hashMap.containsKey(node.getVertex())) {
                result.put(node.getVertex(), hashMap.get(node.getVertex()).getVertex());   // put node with shortest distance in the map
            }

            for (Node neighbour : edgeList.get(node.getVertex())) {               // checks for each neighbour of a particular vertex
                if (priorityQueueMap.containsKey(neighbour.getVertex()) && priorityQueueMap.get(neighbour.getVertex()).getWeight() > neighbour.getWeight()) {
                    pq.remove(priorityQueueMap.get(neighbour.getVertex()));

                    Node temp = new Node(neighbour.getVertex(), neighbour.getWeight());
                    pq.add(temp);
                    priorityQueueMap.put(neighbour.getVertex(), temp);

                    hashMap.put(neighbour.getVertex(), node);
                }
            }
        }
        return result;
    }
}
