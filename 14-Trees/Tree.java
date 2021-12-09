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

    // Size of a binary tree

    public int calculateSize(Node root) {

        if (root == null) {
            return 0;
        }
        return 1 + calculateSize(root.left) + calculateSize(root.right);

    }

    public int getMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.val, Math.max(getMax(root.left), getMax(root.right)));

    }

    public void leftView(Node root) {
        Deque<Node> dq = new ArrayDeque<Node>();

        dq.add(root);

        while (!dq.isEmpty()) {
            int count = dq.size();
            for (int i = 0; i < count; i++) {
                Node curr = dq.poll();
                if (i == 0) {
                    System.out.print(curr.val + " ");
                }
                if (curr.left != null) {

                    dq.add(curr.left);
                }
                if (curr.right != null) {

                    dq.add(curr.right);
                }
            }

        }
    }

    public boolean isChildrenSum(Node root) {

        if (root == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return true;
        }

        int sum = 0;
        if (root.left != null) {
            sum += root.left.val;
        }
        if (root.right != null) {
            sum += root.right.val;
        }

        return (sum == root.val && isChildrenSum(root.left) && isChildrenSum(root.right));

    }

    public int isBalancedSubTree(Node root) {
        if (root == null) {
            return 0;
        }
        int lheight = 1 + isBalancedSubTree(root.left);
        int rheight = 1 + isBalancedSubTree(root.right);
        int diff = Math.abs(lheight - rheight);
        if (diff > 1 || lheight < 0 || rheight < 0) {
            return -1;
        }
        return Math.max(lheight, rheight);

    }

}

class Tree {
    public static void main(String[] args) {

        // Node root = new Node(4);
        // root.left = new Node(7);
        // root.right = new Node(2);
        // root.right.left = new Node(5);
        // root.right.right = new Node(1);
        // root.right.left.right = new Node(8);
        // root.left.right = new Node(9);
        // root.left.right.left = new Node(6);
        // root.left.right.right = new Node(3);

        Node root = new Node(18);
        root.left = new Node(4);
        root.right = new Node(20);
        root.right.left = new Node(13);
        root.right.right = new Node(13);
        root.right.right.right = new Node(13);
        root.right.right.right.right = new Node(13);

        // System.out.println("Pre Order Traversal");
        // root.preorder_traversal(root);
        // System.out.println("\nIn Order Traversal");
        // root.inorder_traversal(root);
        // System.out.println("\nPost Order Traversal");
        // root.postorder_traversal(root);

        root.level_order(root);

        // System.out.println(root.calculateHeight(root));

        // root.printKthNode(root, 2);

        // root.printLevel(root);
        // root.printLevelLineByLine(root);

        // System.out.println(root.calculateSize(root));
        // System.out.println(root.getMax(root));
        // root.leftView(root);
        // System.out.println(root.isChildrenSum(root));
        System.out.println(root.isBalancedSubTree(root));

    }
}