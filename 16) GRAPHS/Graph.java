import java.util.*;

class Graph{
	ArrayList<GraphNode> nodeList ;
	int[][] adjacencyMatrix;

	public Graph(ArrayList<GraphNode> nodeList){
		this.nodeList = nodeList;
		adjacencyMatrix = new int[this.nodeList.size()][this.nodeList.size()]; // if we dont give value, the values are 0
	}

	public void addUndirectedEdge(int i, int j){ // taking the indices of the undirected graph edge
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
	}
	public void printMatrix(){ // NOTE names should be small in size :)
		System.out.print(" ");
		for(GraphNode g : this.nodeList){
			System.out.print("  "+g.name);
		}
		System.out.println();
		for(int i=0; i<adjacencyMatrix[0].length; i++){
			System.out.print(this.nodeList.get(i).name+ "  ");
			for(int j=0; j<adjacencyMatrix[0].length; j++){
				System.out.print(this.adjacencyMatrix[i][j]+"  ");
			}
			System.out.println();
		}
	}
}

