public class Node {
    int value;
    Node left = null;
    Node right = null;
    int depth = 0;

    Node() {
    }

    Node(int value) {
        this.value = value;
    }
}