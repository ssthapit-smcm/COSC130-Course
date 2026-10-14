package labs.recursion;

/**
 * Counts how many times the memoized Fibonacci method is called
 * for each n from 0 to N, and the ratio to the previous count.
 */
public class FibCountMemo {

    /** The largest n to compute fib(n) for. */
    static final int MAX_N = 20;

    /** The number of calls made to itself */
    static int calls = 0;

    /**
     * Computes the nth Fibonacci number using memoization.
     * Creates the memo array and starts the recursion.
     *
     * @param n the position in the Fibonacci sequence (n ≥ 0)
     * @return the nth Fibonacci number
     */
    public static int fib(int n) {
        int[] memo = new int[n + 1];    // all 0
        return fibMemo(n, memo);
    }

    /**
     * Computes the nth Fibonacci number recursively, saving each answer in
     * memo so it is computed only once. Counts each call by adding 1 to
     * calls.
     *
     * @param n    the position in the Fibonacci sequence (n ≥ 0)
     * @param memo saved answers, where 0 means not computed yet
     * @return the nth Fibonacci number
     */
    private static int fibMemo(int n, int[] memo) {
        calls++;
        if (n < 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];             // already computed: look it up
        }
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }

    /**
     * Prints fib(n), the number of calls it made, and the ratio of that
     * count to the previous one, for n from 0 to N.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int previousCalls = 0;
        for (int n = 0; n <= MAX_N; n++) {
            calls = 0;
            int result = fib(n);
            System.out.print("fib(" + n + ") = " + result + ", calls = " + calls);
            if (previousCalls > 0) {
                double ratio = (double) calls / previousCalls;
                System.out.printf(", ratio = %d/%d = %.2f", calls, previousCalls, ratio);
            }
            System.out.println();
            previousCalls = calls;
        }
    }
}
