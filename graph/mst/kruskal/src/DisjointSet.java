//This algorithm uses path compression algorithm

import java.util.HashMap;

public class DisjointSet {
    private HashMap<Integer, GraphNode> hm;

    public DisjointSet() {
        hm = new HashMap<>();
    }

    public void makeSet(int value) {                //creates set for each node
        GraphNode node = new GraphNode();
        node.setVertex(value);
        node.setParent(node);
        node.setRank(1);
        hm.put(value, node);
    }

    public GraphNode findSet(int value) {          //returns the parent node
        GraphNode temp = hm.get(value);
        while (temp.getParent() != temp)
            temp = temp.getParent();

        return temp;
    }

    public void union(int node1, int node2) {     //combine two sets and follows path compression algo
        GraphNode temp1 = findSet(node1);
        GraphNode temp2 = findSet(node2);

        if (temp1.getRank() == temp2.getRank()) {
            if (temp1.getVertex() < temp2.getVertex()) {
                temp2.setParent(temp1);
                temp1.setRank(temp1.getRank() + 1);
            } else {
                temp1.setParent(temp2);
                temp2.setRank(temp2.getRank() + 1);
            }
        } else if (temp1.getRank() < temp2.getRank()) {
            temp1.setParent(temp2);
        } else {
            temp2.setParent(temp1);
        }
    }
}
