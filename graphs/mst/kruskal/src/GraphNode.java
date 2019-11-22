
public class GraphNode {
    private int vertex;
    private int rank;
    private GraphNode parent;

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }

    public int getVertex() {
        return vertex;
    }

    public int getRank() {
        return rank;
    }

    public GraphNode getParent() {
        return parent;
    }
}
