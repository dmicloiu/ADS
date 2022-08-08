public class SelectionSort {

    /**
     * @param elements Array of integers to be sorted.
     */
    public static void selectionSort(int[] elements) {

        int i = 0;
        while (i < elements.length) {
            int index = i;
            int min = elements[i];
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < min) {
                    min = elements[j];
                    index = j;
                }
            }
            int aux = elements[i];
            elements[i] = elements[index];
            elements[index] = aux;

            i++;
        }
    }

}
