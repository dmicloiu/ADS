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