package _1_Basic;

public class Factorial {

    /** recursion method -> what is recursion? ->Recursion is the technique of making
     *  a function call itself. This technique provides a way to break complicated
     * problems down into simple problems which are easier to solve.
     * <p></p>
     * what is factorial -> Factorial Program in Java: Factorial of n
     * is the product of all positive descending integers.
     * Factorial of n is denoted by n!. For example: 4! = 4*3*2*1 = 24.
     */

    public static void main(String[] args) {
        System.out.println(factorial(2));
        System.out.println(factories_iterative(2));
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }

    /**
     * A program is called recursive when an entity calls itself.
     * A program is call iterative when there is a loop
     */
    public static int factories_iterative(int n) {
        int result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return result;
    }
}

