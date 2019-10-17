import java.util.HashMap;

public class MainApp {
    public static void main(String[] args) {
        Service service = new Service(6);
        service.addEdge(1, 2, 5);
        service.addEdge(1, 5, 2);
        service.addEdge(1, 4, 9);
        service.addEdge(2, 3, 2);
        service.addEdge(3, 4, 3);
        service.addEdge(4, 6, 2);
        service.addEdge(5, 6, 3);

        HashMap<Integer, Integer> result = service.getShortestDistance();

        for (int vertex : result.keySet()) {
            System.out.println("vertex:" + (vertex + 1) + " weight:" + result.get(vertex));
        }
    }
}
