package labs.recursion;

/**
 * Counts how many times the recursive Fibonacci method is called
 * for each n from 0 to N.
 * 
 * @author Sandeep Sthapit
 */
public class FibCount {

    /** The largest n to compute fib(n) for. */
    static final int MAX_N = 20;

    /** The number of calls made to fib. */
    static int calls = 0;

    /**
     * Computes the nth Fibonacci number recursively, and counts each call
     * by adding 1 to calls.
     *
     * @param n the position in the Fibonacci sequence (n ≥ 0)
     * @return the nth Fibonacci number
     */
    public static int fib(int n) {
        calls++;
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * Prints fib(n) and the number of calls it made, for n from 0 to Max.
     *
     * @param args command-line arguments
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
