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



