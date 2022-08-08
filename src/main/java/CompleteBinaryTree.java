import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    /**
     * Computes whether the BinaryTree is complete.
     *
     * @param tree the BinaryTree to check.
     * @return true iff the BinaryTree is complete, else false.
     */
    public static boolean isTreeComplete(BinaryTree tree) {
        if (tree == null) {
            return true;
        }
        Queue<BinaryTree> q = new LinkedList<>();
        q.offer(tree);
        boolean okay = false;
        while (!q.isEmpty()) {
            BinaryTree current = q.poll();

            if (!current.hasLeft() && current.hasRight()) {
                return false;
            }
            if (!current.hasLeft() && !current.hasRight()) {
                okay = true;
            }
            if (current.hasLeft() && current.hasRight()) {
                if (okay) {
                    return false;
                } else {
                    q.offer(current.getLeft());
                    q.offer(current.getRight());
                }
            }
            if (current.hasLeft() && !current.hasRight()) {
                if (okay) {
                    return false;
                } else {
                    q.offer(current.getLeft());
                    okay = true;
                }

            }
        }
        return true;

    }
}

class BinaryTree {

    private int key;

    private BinaryTree left, right;

    /**
     * Simple constructor.
     *
     * @param key to set as key.
     */
    public BinaryTree(int key) {
        this.key = key;
    }

    /**
     * Extended constructor.
     *
     * @param key   to set as key.
     * @param left  to set as left child.
     * @param right to set as right child.
     */
    public BinaryTree(int key, BinaryTree left, BinaryTree right) {
        this.key = key;
        setLeft(left);
        setRight(right);
    }

    public int getKey() {
        return key;
    }

    /**
     * Gives the left child of this node.
     *
     * @return the left child.
     */
    public BinaryTree getLeft() {
        return left;
    }

    /**
     * Gives the right child of this node.
     *
     * @return the right child.
     */
    public BinaryTree getRight() {
        return right;
    }

    /**
     * Indicates whether this node has a left child.
     *
     * @return true if there is a left child, false otherwise
     */
    public boolean hasLeft() {
        return left != null;
    }

    /**
     * Indicates whether this node has a right child.
     *
     * @return true if there is a right child, false otherwise
     */
    public boolean hasRight() {
        return right != null;
    }

    /**
     * Sets the left child of this node.
     *
     * @param left to set
     */
    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    /**
     * Sets the right child of this node.
     *
     * @param right to set
     */
    public void setRight(BinaryTree right) {
        this.right = right;
    }
}

