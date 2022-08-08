import java.util.ArrayList;
import java.util.List;

public class MSDRadixSort {

    /**
     * Sorts a list of words using MSD radix sort.
     *
     * @param words The list of words to sort.
     * @return The sorted list of words.
     * @throws NullPointerException If `words` equals `null`.
     */
    static List<String> radixSortMSD(List<String> words) {
        return sortByChar(words, 0);
    }

    private static List<String> sortByChar(List<String> words, int pos) {
        if (words.size() <= 1) {
            return words;
        }

        List<List<String>> bucketArray = new ArrayList<>(26);


        for (int i = 0; i < 26; i++) {
            bucketArray.add(new ArrayList<>());
        }

        List<String> result = new ArrayList<>(words.size());

        for (String word : words) {
            if (word.length() > pos) {
                int bucket = word.charAt(pos) - 'a';
                bucketArray.get(bucket).add(word);
            } else {
                result.add(word);
            }
        }

        for (int i = 0; i < 26; i++) {
            result.addAll(sortByChar(bucketArray.get(i), pos + 1));
        }

        return result;
    }

}
