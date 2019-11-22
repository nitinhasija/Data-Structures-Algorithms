public class Node {
    private int weight;
    private int vertex;

    public Node(int vertex, int weight) {
        this.weight = weight;
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public int getVertex() {
        return vertex;
    }
}
