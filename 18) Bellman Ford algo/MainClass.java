public class MainClass {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();
        WeightedNode a = new WeightedNode("A");
        WeightedNode b = new WeightedNode("B");
        WeightedNode c = new WeightedNode("C");
        WeightedNode d = new WeightedNode("D");
        WeightedNode e = new WeightedNode("E");
        WeightedNode f = new WeightedNode("F");
        a.addNeighbour(b, 2);
        a.addNeighbour(c, 4);
        b.addNeighbour(d, 8);
        c.addNeighbour(d, 3);
        e.addNeighbour(d, -5);
        d.addNeighbour(f, 2);
        f.addNeighbour(e, 1);
        graph.add(a, 0);
        graph.add(b, 1);
        graph.add(c, 2);
        graph.add(d, 3);
        graph.add(e, 4);
        graph.add(f, 5);
        BellmanFord.bFord(a, graph);
        for (WeightedNode z : graph.graph) {
            System.out.println(z.name + " : " + z.weight);
        }
    }
}
