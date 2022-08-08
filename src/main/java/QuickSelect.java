import java.util.ArrayList;
import java.util.List;

public class QuickSelect {

    public static Integer quickSelect(List<Integer> l, int k) {
        if (l == null || l.isEmpty() || k < 1 || k > l.size()) {
            return null;
        }
        return quickSelectHelper(l, k - 1);
    }

    private static Integer quickSelectHelper(List<Integer> l, int k) {
        if (l.size() == 1) {
            return l.get(0);
        }

        int pivot = l.get(0);

        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for (Integer i : l) {
            if (i < pivot) {
                less.add(i);
            } else if (i == pivot) {
                equal.add(i);
            } else {
                greater.add(i);
            }
        }

        if (k < less.size()) {
            return quickSelectHelper(less, k);
        } else if (k < less.size() + equal.size()) {
            return pivot;
        } else {
            return quickSelectHelper(greater, k - less.size() - equal.size());
        }
    }

}
