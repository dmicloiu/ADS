public class IsRedBlackTree {

    /**
     * Checks whether the given BinaryTree is a Red Black Tree.
     *
     * @param tree
     * BinaryTree to check.
     * @return True if the given tree is a Red Black Tree, false otherwise.
     */

    private static int depth;

    public static boolean isRedBlackTree(BinaryTree tree) {
        if (tree == null) {
            return true;
        }
        depth = calculateDepth(tree, 0);

        //System.out.println(depth);
        return isBSTree(tree, Integer.MIN_VALUE, Integer.MAX_VALUE)
                && tree.isBlack()
                // && externalProperty(tree)
                && redProperty(tree)
                && blackDepth(tree, 0)
                ;
    }

    public static boolean isBSTree(BinaryTree tree, int min, int max) {
        if (tree == null) {
            return true;
        }

        if (tree.getValue() < min || tree.getValue() > max) {
            return false;
        }

        return (isBSTree(tree.getLeft(), min, tree.getValue() - 1)
                && isBSTree(tree.getRight(), tree.getValue() + 1, max));
    }


/*  not needed!!!
    public static boolean externalProperty(BinaryTree tree){
        if(tree == null){
            return true;
        }
        if(!tree.hasLeft() && !tree.hasRight() && tree.isRed()){
            return false;
        }
        if(!externalProperty(tree.getLeft()) || !externalProperty(tree.getRight())){
            return false;
        }

        return true;
    }

*/

    public static boolean redProperty(BinaryTree tree) {
        if (tree == null) {
            return true;
        }

        if (tree.isRed()) {
            if (tree.hasLeft() && tree.getLeft().isRed()) {
                return false;
            }
            if (tree.hasRight() && tree.getRight().isRed()) {
                return false;
            }
        }

        return redProperty(tree.getLeft()) && redProperty(tree.getRight());
    }


    public static boolean blackDepth(BinaryTree tree, int previous) {
        if (tree == null) {
            if (previous != depth) {
                return false;
            } else {
                return true;
            }
        }

      /* if(!tree.hasLeft() && ! tree.hasRight()){
           if(previous != depth){
               return false;
           }
       }*/
        if (tree.isBlack()) {
            previous++;
        }

        if (!blackDepth(tree.getLeft(), previous) || !blackDepth(tree.getRight(), previous)) {
            return false;
        }

        return true;

    }

    public static int calculateDepth(BinaryTree tree, int previous) {
        if (tree == null) {
            return previous;
        }

        if (tree.isBlack()) {
            return Math.max(calculateDepth(tree.getLeft(), previous + 1), calculateDepth(tree.getRight(), previous + 1));
        } else {
            return Math.max(calculateDepth(tree.getLeft(), previous), calculateDepth(tree.getRight(), previous));
        }
    }

/*

    public static boolean blackDepth(BinaryTree tree){
        if(tree == null){
            return true;
        }

        if(calculateDepth(tree.getLeft())!=calculateDepth(tree.getRight())){
            return false;
        }
        return blackDepth(tree.getLeft()) && blackDepth(tree.getRight());
    }


    public static int calculateDepth(BinaryTree tree){
        if(tree == null){
            return 0;
        }

        if(tree.isBlack()){
            return Math.max(calculateDepth(tree.getLeft()), calculateDepth(tree.getRight()))+1 ;
        }
        else {
            return Math.max(calculateDepth(tree.getLeft()), calculateDepth(tree.getRight()));
        }
    }
    */

}