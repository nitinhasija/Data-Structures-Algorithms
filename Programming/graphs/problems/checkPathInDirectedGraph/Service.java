import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Service {
    private ArrayList<ArrayList<Integer>> list;

    public Service(int vertex) {
        list = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            list.add(new ArrayList());
        }
    }

    public void addEdservicee(int vertex1, int vertex2) {
        list.get(vertex1).add(vertex2);                  // directed graph
    }


    public boolean isThereAnyPathBetween(int u, int v) {
        if (u == v)
            return false;                               // when source = destination

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        queue.add(u);
        while (!queue.isEmpty()) {                    // bfs
            int vertex = queue.remove();
            hashSet.add(vertex);
            for (int neighbour : list.get(vertex)) {
                if (neighbour == v)
                    return true;

                if (!hashSet.contains(neighbour)) {
                    hashSet.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }
}
