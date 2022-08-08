import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {
    /**
     * @param elements Array of integers to be sorted.
     * @return New array of sorted integers.
     */
    public static int[] mergeSort(int[] elements) {
        if (elements == null) {
            return null;
        }

        int n = elements.length;
        if (n < 2) {
            return elements;
        }

        int mid = n / 2;
        int[] left = Arrays.copyOfRange(elements, 0, mid);
        int[] right = Arrays.copyOfRange(elements, mid, n);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int n = left.length, m = right.length;
        int[] answer = new int[n + m];

        int i = 0, j = 0, index = 0;
        while (i < n && j < m) {
            if (left[i] < right[j]) {
                answer[index++] = left[i++];
            } else {
                answer[index++] = right[j++];
            }
        }

        while (i < n) {
            answer[index++] = left[i++];
        }

        while (j < m) {
            answer[index++] = right[j++];
        }

        return answer;
    }


    /// Merge sort using Queues

    /**
     * @param queue1 first sorted Queue to be merged
     * @param queue2 second sorted Queue to be merged
     * @return sorted Queue containing all elements from both Queues
     */
    public static LibraryQueue<Integer> merge(
            LibraryQueue<Integer> queue1, LibraryQueue<Integer> queue2) {


        LibraryQueue<Integer> answer = new LibraryQueue<>();

        if (queue1 == null && queue2 == null) {
            return null;
        }

        if (queue1 == null) {

            int m = queue2.size();
            while (m != 0) {
                int element = queue2.dequeue();
                m--;
                answer.enqueue(element);
                queue2.enqueue(element);
            }
            return answer;

        }

        if (queue2 == null) {

            int n = queue1.size();
            while (n != 0) {
                int element = queue1.dequeue();
                n--;
                answer.enqueue(element);
                queue1.enqueue(element);
            }
            return answer;
        }


        if (queue1 == queue2) {
            int n = queue1.size();
            queue2 = new LibraryQueue<>();

            while (n != 0) {
                int element = queue1.dequeue();
                n--;
                queue2.enqueue(element);
                queue1.enqueue(element);
            }

        }

        int n = queue1.size(), m = queue2.size();

        while (n != 0 && m != 0) {
            if (queue1.front() > queue2.front()) {
                int element = queue1.dequeue();
                n--;
                answer.enqueue(element);
                queue1.enqueue(element);
            } else {
                int element = queue2.dequeue();
                m--;
                answer.enqueue(element);
                queue2.enqueue(element);
            }
        }

        while (n != 0) {
            int element = queue1.dequeue();
            n--;
            answer.enqueue(element);
            queue1.enqueue(element);
        }

        while (m != 0) {
            int element = queue2.dequeue();
            m--;
            answer.enqueue(element);
            queue2.enqueue(element);
        }

        return answer;
    }


    /// Merge sort in place

    /**
     * Sorts and merges `in[start, ..., start + inc - 1]` and `in[start + inc, ..., start + 2*inc - 1]` into `out`.
     *
     * @param in    The input array, sorted in their intervals `in[start, ..., start + inc - 1]` and `in[start + inc, ..., start + 2*inc - 1]`.
     * @param out   The output array that should be updated to have `in[start, ..., start + inc - 1]` and `in[start + inc, ..., start + 2*inc - 1]`
     *              in sorted fashion at `out[start, start + 2*inc - 1]`.
     * @param start The index of the first element to be merged into out.
     * @param inc   The size of each of the intervals to be merged into out.
     */
    public static void merge(int[] in, int[] out, int start, int inc) {
        int n = in.length;

        int end1 = Math.min(start + inc, n);
        int end2 = Math.min(start + 2 * inc, n);

        int i = start;
        int j = start + inc;
        int index = start;

        while (i < end1 && j < end2) {
            if (in[i] < in[j]) {
                out[index++] = in[i++];
            } else {
                out[index++] = in[j++];
            }
        }

        while (i < end1) {
            out[index++] = in[i++];
        }

        while (j < end2) {
            out[index++] = in[j++];
        }
    }

    /**
     * Sorts the input array using bottom-up merge sort.
     *
     * @param array The array to be sorted.
     * @return The resulting sorted array.
     */
    public static int[] mergeSortBottomUp(int[] array) {

        int n = array.length;
        int[] temp = new int[n];


        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n; j += 2 * i) {
                merge(array, temp, j, i);
            }
            int[] modified = array;
            array = temp;
            temp = modified;
        }

        return array;
    }

}

class LibraryQueue<T> {

    private LinkedList<T> q;

    public LibraryQueue() {
        this.q = new LinkedList<>();
    }

    public void enqueue(T e) {
        q.add(e);
    }

    public T dequeue() {
        return q.poll();
    }

    public int size() {
        return q.size();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public T front() {
        return q.peek();
    }
}



