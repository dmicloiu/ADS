import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FastestFibonacciTest {

    @Test
    public void testExample() {
        assertEquals(5, FastestFibonacci.fibonacci(5));
    }

    @Test
    public void testBaseZero() {
        assertEquals(0, FastestFibonacci.fibonacci(0));
    }

    @Test
    public void testBaseOne() {
        assertEquals(1, FastestFibonacci.fibonacci(1));
    }

    @Test
    public void testSmall() {
        assertEquals(13, FastestFibonacci.fibonacci(7));
    }

    @Test
    public void testMedium() {
        assertEquals(55, FastestFibonacci.fibonacci(10));
    }

    @Test
    public void testLarge2() {
        assertEquals(267914296, FastestFibonacci.fibonacci(42));
    }

    @Test
    public void testTime() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 41, 42, 43, 44, 1000));
        for (int n : numbers) {
            runFibWithTime(n);
        }
    }

    public int runFibWithTime(int n) {
        long start = System.currentTimeMillis();
        int res = FastestFibonacci.fibonacci(n);
        long end = System.currentTimeMillis();
        System.out.println(String.format("Elapsed time for %d: %d ms", n, end - start));
        return res;
    }
}
