import java.util.*;

public class DijkstraAlgox {
    public static void djAlgox(WeightedNode startNode, WeightedGraph graph) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        startNode.weight = 0;
        queue.add(startNode);
        while (!queue.isEmpty()) {
            WeightedNode current = queue.poll();
            for (WeightedNode i : current.neighbours) {
                if (i.isVisited) {
                    if (i.weight > current.weights.get(i) + current.weight) {
                        i.weight = current.weights.get(i) + current.weight;
                        i.parent = current;
                    }
                    continue;
                }
                i.weight = current.weight + current.weights.get(i);
                i.parent = current;
                i.isVisited = true;
                queue.add(i);
            }
        }

    }
}
