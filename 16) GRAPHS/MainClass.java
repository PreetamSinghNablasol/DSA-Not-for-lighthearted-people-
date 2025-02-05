import java.util.*;

class MainClass{
	public static void main(String ...args){
		ArrayList<GraphNode> graph = new ArrayList<>();
		graph.add(new GraphNode("A", graph.size()));
		graph.add(new GraphNode("B", graph.size()));
		graph.add(new GraphNode("C", graph.size()));
		graph.add(new GraphNode("D", graph.size()));
		graph.add(new GraphNode("E", graph.size()));
		graph.add(new GraphNode("F", graph.size()));
		graph.add(new GraphNode("G", graph.size()));
		graph.add(new GraphNode("H", graph.size()));
		graph.add(new GraphNode("I", graph.size()));

		Graph g = new Graph(graph);
		g.addUndirectedEdge(0,1);
		g.addUndirectedEdge(5,1);
		g.addUndirectedEdge(7,4);
		g.addUndirectedEdge(6,2);
		g.addUndirectedEdge(8,5);
		g.addUndirectedEdge(5,3);

		g.printMatrix();
	}
}