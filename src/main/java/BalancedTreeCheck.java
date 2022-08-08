public class BalancedTreeCheck {

    /**
     * This method checks whether the given tree has the height-balance property.
     *
     * @param tree the tree to check.
     * @return true iff the tree has the height-balance property, false otherwise.
     */
    public static boolean isTreeBalanced(BinaryTree tree) {
        if (tree == null) {
            return true;
        }


        if (Math.abs(height(tree.getLeft()) - height(tree.getRight())) > 1) {
            return false;
        } else {
            return isTreeBalanced(tree.getLeft()) && isTreeBalanced(tree.getRight());
        }
    }

    public static int height(BinaryTree tree) {
        if (tree == null) {
            return 0;
        } else {
            return Math.max(height(tree.getLeft()), height(tree.getRight())) + 1;
        }

    }
}
