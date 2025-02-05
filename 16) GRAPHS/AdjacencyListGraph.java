import java.util.*;

class AdjacencyListNode {
    String name;
    int index;
    ArrayList<AdjacencyListNode> adjacent;

    public AdjacencyListNode(String name, int index) {
        this.name = name;
        this.index = index;
        adjacent = new ArrayList<>();
    }
}

class AdjacencyList {
    ArrayList<AdjacencyListNode> list;

    public AdjacencyList(ArrayList<AdjacencyListNode> list) {
        this.list = list;
    }

    public void addUndirectedEdge(int a, int b) {
        if (!this.list.get(a).adjacent.contains(this.list.get(b))) {
            this.list.get(a).adjacent.add(this.list.get(b));
        }
        if (!this.list.get(b).adjacent.contains(this.list.get(a))) {
            this.list.get(b).adjacent.add(this.list.get(a));
        }
    }

    public void addDirectedEdge(int a, int b) {
        if (!this.list.get(a).adjacent.contains(this.list.get(b))) {
            this.list.get(a).adjacent.add(this.list.get(b));
        }
    }

    public void printIt() {
        for (int i = 0; i < this.list.size(); i++) {
            System.out.print(this.list.get(i).name + ":  ");
            for (int j = 0; j < this.list.get(i).adjacent.size(); j++) {
                System.out.print(this.list.get(i).adjacent.get(j).name + "  ");
            }
            System.out.println();
        }
    }

    public void bfsTraversal() {
        HashSet<AdjacencyListNode> set = new HashSet<>();// for maintaining track of elements that have come already
        LinkedList<AdjacencyListNode> queue = new LinkedList<>();
        queue.add(this.list.get(0));
        while (queue.size() != 0) {
            AdjacencyListNode temp = queue.pollFirst();
            if (set.contains(temp))
                continue;
            else {
                queue.addAll(temp.adjacent);
                set.add(temp);
            }
            System.out.print(temp.name + " -> ");
        }
    }

    public void dfsTraversal() {
        HashSet<AdjacencyListNode> set = new HashSet<>();
        LinkedList<AdjacencyListNode> stack = new LinkedList<>();
        stack.add(this.list.get(0));
        while (stack.size() != 0) {
            AdjacencyListNode temp = stack.pollLast();
            if (set.contains(temp)) {
                continue;
            } else {
                stack.addAll(temp.adjacent);
                set.add(temp);
            }
            System.out.print(temp.name + " -> ");
        }
    }

    // Topological Sort
    public ArrayList<AdjacencyListNode> topologicalSort() {
        LinkedList<AdjacencyListNode> stack = new LinkedList<>();
        for (AdjacencyListNode n : list) {
            if (!stack.contains(n)) {
                this.topologicalRecursive(stack, n);
            }
        }
        return new ArrayList<AdjacencyListNode>(stack);
    }

    public void topologicalRecursive(LinkedList<AdjacencyListNode> stack, AdjacencyListNode node) {
        if (node.adjacent.size() == 0) {
            stack.addFirst(node);
            return;
        }
        for (AdjacencyListNode n : node.adjacent) {
            if (!stack.contains(n)) {
                topologicalRecursive(stack, n);
            }
        }
        stack.addFirst(node);

    }

    // SSSPP using BFS to identify the path that needs the least number of hops.
    public void bfsBestPath(AdjacencyListNode starting) {
        HashMap<AdjacencyListNode, AdjacencyListNode> parentMap = new HashMap<>(); // track of parents
        HashSet<AdjacencyListNode> set = new HashSet<>(); // to check the visited nodes
        LinkedList<AdjacencyListNode> queue = new LinkedList<>(); // queue for BFS
        queue.addFirst(starting);
        while (queue.size() > 0) {
            AdjacencyListNode current = queue.pollLast();
            if (set.contains(current))
                continue;
            set.add(current);
            for (AdjacencyListNode a : current.adjacent) {
                if (!parentMap.containsKey(a)) {
                    parentMap.put(a, current);
                    queue.addFirst(a);
                }
            }
        }
    }
}

class AdjacencyListGraph {
    public static void main(String... args) {
        ArrayList<AdjacencyListNode> graph = new ArrayList<>();
        graph.add(new AdjacencyListNode("A", graph.size()));
        graph.add(new AdjacencyListNode("B", graph.size()));
        graph.add(new AdjacencyListNode("C", graph.size()));
        graph.add(new AdjacencyListNode("D", graph.size()));
        graph.add(new AdjacencyListNode("E", graph.size()));
        graph.add(new AdjacencyListNode("F", graph.size()));
        graph.add(new AdjacencyListNode("G", graph.size()));
        graph.add(new AdjacencyListNode("H", graph.size()));

        AdjacencyList g = new AdjacencyList(graph);
        g.addDirectedEdge(0, 1);
        g.addDirectedEdge(0, 2);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(1, 3);
        g.addDirectedEdge(2, 4);
        g.addDirectedEdge(3, 5);
        g.addDirectedEdge(5, 6);
        g.addDirectedEdge(5, 7);

        for (AdjacencyListNode n : g.topologicalSort()) {
            System.out.print(n.name + " -> ");
        }
    }
}