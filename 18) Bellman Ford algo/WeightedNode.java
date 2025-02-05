import java.lang.Comparable;
import java.util.*;

class WeightedNode implements Comparable<WeightedNode> {
    String name;
    ArrayList<WeightedNode> neighbours = new ArrayList<>();
    HashMap<WeightedNode, Integer> weights = new HashMap<>();
    WeightedNode parent; // parent node value
    boolean isVisited; // is visited parameter
    int weight; // distance from the target Node :)

    public WeightedNode(String name) {
        this.name = name;
        this.isVisited = false;
        this.weight = Integer.MAX_VALUE;
    }

    @Override
    public int compareTo(WeightedNode o) {
        return this.weight - o.weight;
    }

    public String toString() {
        return name;
    }

    public void addNeighbour(WeightedNode neighbour, int edgeWeight) {
        this.neighbours.add(neighbour);
        this.weights.put(neighbour, edgeWeight);
        neighbour.parent = this;
    }
}
