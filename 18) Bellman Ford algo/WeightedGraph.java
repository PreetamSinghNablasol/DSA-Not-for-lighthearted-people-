import java.util.*;

public class WeightedGraph {
    ArrayList<WeightedNode> graph;

    public WeightedGraph() {
        this.graph = new ArrayList<>();
    }

    public void add(WeightedNode node, int index) {
        this.graph.add(index, node);
    }

}
