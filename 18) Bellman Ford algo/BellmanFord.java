import java.util.*;

public class BellmanFord {
    public static boolean bFord(WeightedNode startNode, WeightedGraph graph) { // false is returned if there is negative
                                                                               // cycle
        startNode.weight = 0;
        for (int i = 0; i < graph.graph.size(); i++) {
            for (int a = 0; a < graph.graph.size(); a++) {
                for (int j = 0; j < graph.graph.get(a).weights.size(); j++) {
                    if (graph.graph.get(a).neighbours.get(j).weight > graph.graph.get(a).weight
                            + graph.graph.get(a).weights.get(
                                    graph.graph.get(a).neighbours.get(j))) {
                        if (i == graph.graph.size() - 1) { // if we enter this if condition, on nth cycle, then there is
                                                           // a negative cycle.
                            System.out.println("Negative Cycle Detected !!! \n\n\n");
                            return false;
                        }
                        graph.graph.get(a).neighbours.get(j).weight = graph.graph.get(a).weight
                                + graph.graph.get(a).weights.get(
                                        graph.graph.get(a).neighbours.get(j));
                    }
                }
            }
        }
        System.out.println(" No Negative Cycles Detected !!! \n\n\n");
        return true;
    }
}
