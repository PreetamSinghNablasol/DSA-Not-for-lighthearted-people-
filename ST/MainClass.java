import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        LinkedList<Node> queue = new LinkedList<>();
        int level = 1;
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.left = n2;
        n2.right = n4;
        n1.right = n3;
        n3.left = n5;
        n3.right = n6;
        n6.left = n7;
        n7.right = n8;

        inOrder(n1, 0);
        queue.addFirst(n1);
        level = 0;

        while (!queue.isEmpty()) {
            Node temp = queue.removeLast();
            if (temp.left != null)
                queue.addFirst(temp.left);
            if (temp.right != null)
                queue.addFirst(temp.right);
            if (temp.depth != level || temp.depth == 0) {
                System.out.println(temp.value);
                level = temp.depth;
            }
        }

    }

    public static void inOrder(Node root, int depth) {
        if (root == null)
            return;
        root.depth = depth;
        inOrder(root.left, depth + 1);
        inOrder(root.right, depth + 1);
    }

}
