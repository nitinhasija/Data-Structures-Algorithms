import java.util.HashMap;

public class MainApp {
    public static void main(String[] args) {
        Service service = new Service(5);
        service.addEdge(3, 4, 2);
        service.addEdge(4, 3, 1);
        service.addEdge(2, 4, 4);
        service.addEdge(0, 2, 5);
        service.addEdge(1, 2, -3);
        service.addEdge(0, 3, 8);
        service.addEdge(0, 1, 4);

        HashMap<Integer, Integer> result = service.getShortestPath();

        if (result == null) {
            System.out.println("Negative Weight Cycle Exists");
        } else {
            for (int destination : result.keySet()) {
                System.out.println("Source:" + 0 + " Destination:" + destination + " Distance: " + result.get(destination));
            }
        }
    }
}
