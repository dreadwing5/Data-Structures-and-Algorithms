import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Node {

    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    public void preorder_traversal(Node root) {

        if (root == null)
            return;
        System.out.print(root.val + " ");
        preorder_traversal(root.left);
        preorder_traversal(root.right);

    }

    public void inorder_traversal(Node root) {
        if (root == null)
            return;
        inorder_traversal(root.left);
        System.out.print(root.val + " ");
        inorder_traversal(root.right);
    }

    public void postorder_traversal(Node root) {
        if (root == null)
            return;
        postorder_traversal(root.right);
        postorder_traversal(root.left);
        System.out.print(root.val + " ");

    }

    public void level_order(Node root) {

        ArrayList<Node> node = new ArrayList<>();
        node.add(root);

        int ptr = 0;
        while (ptr != node.size()) {
            Node curr = node.get(ptr);
            System.out.print(curr.val + " ");
            if (curr.left != null) {
                node.add(curr.left);
            }
            if (curr.right != null) {
                node.add(curr.right);
            }
            ptr++;
        }

        System.out.println();

    }

    public void printLevel(Node root) {

        Deque<Node> node = new ArrayDeque<>();
        node.add(root);
        while (!node.isEmpty()) {
            Node curr = node.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) {
                node.add(curr.left);
            }
            if (curr.right != null) {
                node.add(curr.right);
            }
        }

    }

    public void printLevelLineByLine(Node root) {

        Deque<Node> node = new LinkedList<>();
        node.add(root);
        node.add(null);
        while (node.size() > 1) {
            Node curr = node.poll();
            if (curr == null) {
                System.out.println();
                node.add(null);
                continue;
            } else
                System.out.print(curr.val + " ");
            if (curr.left != null) {
                node.add(curr.left);
            }
            if (curr.right != null) {
                node.add(curr.right);
            }
        }
        System.out.println();

    }

    public int calculateHeight(Node root) {

        if (root == null)
            return 0;
        else {
            return Math.max(calculateHeight(root.left), calculateHeight(root.right)) + 1;
        }
    }

    // Print kth node
    public void printKthNode(Node root, int k) {

        if (root == null)
            return;

        // print the node which is at distance k from the root
        if (k == 0) {
            System.out.print(root.val + " ");
            return;
        }

        else {
            printKthNode(root.left, k - 1);
            printKthNode(root.right, k - 1);
        }
    }

}

class Tree {
    public static void main(String[] args) {

        Node root = new Node(4);
        root.left = new Node(7);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(1);
        root.right.left.right = new Node(8);
        root.left.right = new Node(9);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(3);

        // System.out.println("Pre Order Traversal");
        // root.preorder_traversal(root);
        // System.out.println("\nIn Order Traversal");
        // root.inorder_traversal(root);
        // System.out.println("\nPost Order Traversal");
        // root.postorder_traversal(root);

        root.level_order(root);

        System.out.println(root.calculateHeight(root));

        // root.printKthNode(root, 2);

        // root.printLevel(root);
        root.printLevelLineByLine(root);

    }
}