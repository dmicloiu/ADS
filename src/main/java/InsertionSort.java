public class InsertionSort {

    /**
     * @param elements - array of integers to be sorted.
     */
    public static void insertionSort(int[] elements) {

        int i = 1;
        while (i < elements.length) {
            int val = elements[i];
            for (int j = i - 1; j >= 0; j--) {
                if (elements[j] > val) {
                    //System.out.println(elements[i]);
                    elements[j + 1] = elements[j];
                    elements[j] = val;
                } else {
                    break;
                }
            }
            i++;
        }
    }

}
