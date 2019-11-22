
public class MainApp {
    public static void main(String[] args) {
        Service service = new Service();
        service.addEdge(1, 2, 3);
        service.addEdge(1, 4, 1);
        service.addEdge(2, 3, 1);
        service.addEdge(2, 4, 3);
        service.addEdge(3, 4, 1);
        service.addEdge(3, 5, 5);
        service.addEdge(6, 3, 4);
        service.addEdge(4, 5, 6);
        service.addEdge(5, 6, 2);

        service.printMinimalSpanningTree();
    }
}
