import java.util.LinkedList;
import java.util.Queue;

public class BucketSort {

    @SuppressWarnings("unchecked")
    public static Queue<Integer>[] fillBuckets(int[] array) {
        if(array == null || array.length == 0){
            return new Queue[0];
        }

        int vmin = array[0];
        int vmax = array[0];
        for(int i=1; i<array.length; i++){
            if(vmin>array[i]){
                vmin = array[i];
            }
            if(vmax<array[i]){
                vmax = array[i];
            }
        }

        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];
        for(int i=0; i<buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }

        for(int i=0; i<array.length; i++){
            int element = array[i] - vmin;
            buckets[element].offer(array[i]);
        }
        return buckets;
    }

    public static int[] readBuckets(Queue<Integer>[] buckets) {
        if(buckets == null || buckets.length == 0){
            return new int[0];
        }
        int size = 0;
        for(int i=0; i<buckets.length; i++){
            size+=buckets[i].size();
        }

        int[] answer = new int[size];
        int index = 0;
        for(int i=0; i<buckets.length; i++){
            Queue<Integer> queue = buckets[i];
            while(!queue.isEmpty()){
                answer[index++] = queue.poll();
            }
        }
        return answer;
    }

}
