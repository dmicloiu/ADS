public class MultiwaySearchTreeCheck {

    /**
     * Checks whether the given MultiwaySearchTree satisfies all to conditions.
     * Our reference solution does not change this function in any way.
     *
     * @param tree
     *     MultiwaySearchTree to check.
     * @return True iff the given tree satisfies all conditions.
     */

    //static boolean okay = false;
    public static boolean isSpecialTree(MultiwaySearchTree tree) {
        // okay = false;
        return satisfiesCondition1(tree)
                && satisfiesCondition2(tree)
                && satisfiesCondition3(tree)
                && satisfiesCondition4(tree)
                ;
    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should NOT change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition1(MultiwaySearchTree tree) {
        if(tree == null){
            return true;
        }
        MultiwaySearchTree[] children = tree.getChildren();

        if(children.length>7){
            return false;
        }

        for(MultiwaySearchTree child:children){
            if(!satisfiesCondition1(child)){
                return false;
            }
        }
        return true;
    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should NOT change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition2(MultiwaySearchTree tree) {
        return satisfiesCondition2Helper(tree, 0);
    }

    public static boolean satisfiesCondition2Helper(MultiwaySearchTree tree, int level) {
        if(tree == null){
            return true;
        }
        MultiwaySearchTree[] children = tree.getChildren();

        if(level!=0){

            if(children.length<4 && children[0]!=null){
                return false;
            }

        }

        for(MultiwaySearchTree child:children){
            if(!satisfiesCondition2Helper(child,level+1)){
                return false;
            }
        }
        return true;
    }



    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should NOT change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition3(MultiwaySearchTree tree) {
        if(tree == null){
            return true;
        }

        if(tree.getChildren().length == 0){
            return true;
        }
        else if(tree.getChildren().length>=2){
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Refer to the exercise description what condition you should check here.
     * Note that you should NOT change the method signature (name/parameters/return type).
     */
    public static boolean satisfiesCondition4(MultiwaySearchTree tree) {
        return satisfiesCondition4Helper(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean satisfiesCondition4Helper(MultiwaySearchTree tree, int min, int max){
        if(tree == null){
            return true;
        }

        int[] key = tree.getKeys();

        for(int i:key){
            if(i<min || i>max){
                return false;
            }
        }

        MultiwaySearchTree[] children = tree.getChildren();

        if(!satisfiesCondition4Helper(children[0],min,key[0]-1)){
            return false;
        }

        for(int j = 1; j<key.length; j++){
            if(!satisfiesCondition4Helper(children[j],key[j-1]+1, key[j]-1)){
                return false;

            }
        }

        int j = key.length - 1;
        if(!satisfiesCondition4Helper(children[j+1],key[j]+1,max)){
            return false;
        }
        return true;
    }
}

class MultiwaySearchTree {

    int[] keys;

    MultiwaySearchTree[] children;

    public MultiwaySearchTree(int[] keys, MultiwaySearchTree[] children) {
        this.keys = keys;
        this.children = children;
    }

    public int[] getKeys() {
        return keys;
    }

    public MultiwaySearchTree[] getChildren() {
        return children;
    }
}
