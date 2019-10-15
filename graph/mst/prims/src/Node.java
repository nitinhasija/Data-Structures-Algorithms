public class Node {
    private int vertex;
    private int weight;

    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.weight = distance;
    }

    public int getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }
}
