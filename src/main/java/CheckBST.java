public class CheckBST {

    /**
     * Computes whether the BinaryTree is a binary search tree.
     *
     * @param tree the BinaryTree to check.
     * @return true iff the BinaryTree is a binary search tree, else false.
     */
    public static boolean isTreeBST(BinaryTree tree) {

        return isTreeBSTHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static boolean isTreeBSTHelper(BinaryTree tree, Integer min, Integer max) {
        if (tree == null) {
            return true;
        }

        if (tree.getValue() < min || tree.getValue() > max) {
            return false;
        }

        return (isTreeBSTHelper(tree.getLeft(), min, tree.getValue() - 1)
                && isTreeBSTHelper(tree.getRight(), tree.getValue() + 1, max));

    }

// 50 points solution
      /*
       if(tree == null){
           return true;
       }
       if(tree.hasLeft() && tree.getLeft().getKey() >= tree.getKey()){
           return false;
       }

       if(tree.hasRight() && tree.getRight().getKey() <= tree.getKey()){
           return false;
       }

       if(!isTreeBST(tree.getLeft()) || !isTreeBST(tree.getRight())){
           return false;
       }
       return true;

       */


// 90 points solution

 /*        List<Integer> answer = new ArrayList<>();
        Stack<BinaryTree> go = new Stack<>();

        go.push(tree);
        while(!go.empty()){

            BinaryTree current = go.peek();
            if(current.hasRight()){
                go.push(current.getRight());
                current.setRight(null);
            }
            else if(current.hasLeft()){
                 go.pop();
                 go.push(current.getLeft());
                 answer.add(current.getKey());
            }
            else {
                answer.add(current.getKey());
                go.pop();
            }
        }

        for(int i=0; i<answer.size()-1; i++){
            if(answer.get(i)<=answer.get(i+1)){
                return false;
            }
        }
        return true;
 */

}
