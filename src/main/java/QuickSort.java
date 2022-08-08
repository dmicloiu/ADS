public class QuickSort {
    /**
     * @param elements Array of integers to be sorted.
     */
    public static void quickSort(int[] elements) {
        if (elements == null) {
            return;
        }

        quickSortInPlace(elements, 0, elements.length - 1);


    }

    public static void quickSortInPlace(int[] elements, int start, int end) {
        if (end <= start) {
            return;
        }

        int left = start;
        int right = end - 1;
        int pivot = elements[end];
        //System.out.println(pivot);

        while (left <= right) {

            while (left <= right && pivot > elements[left]) left++;

            while (left <= right && pivot < elements[right]) right--;

            if (left <= right) {
                int aux = elements[left];
                elements[left] = elements[right];
                elements[right] = aux;
                left++;
                right--;
            }
        }

        int aux = elements[end];
        elements[end] = elements[left];
        elements[left] = aux;

        quickSortInPlace(elements, start, left - 1);
        quickSortInPlace(elements, left + 1, end);
    }
}
