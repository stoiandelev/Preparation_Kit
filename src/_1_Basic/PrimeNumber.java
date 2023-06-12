package _1_Basic;

import java.util.Scanner;

public class PrimeNumber {
    /**
     * A prime number is a natural number greater than  whose only positive divisors are  and itself.
     * For example, the first six prime numbers are , , , , , and .
     * Given a large integer, , use the Java BigInteger class'
     * isProbablePrime method to determine and print whether it's prime or not prime.
     * Input Format
     * A single line containing an integer,  (the number to be checked).
     * Constraint
     * contains at most  digits.
     * Output Format
     * If  is a prime number, print prime; otherwise, print not prime.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (isPrime(number)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }

    }

    public static boolean isPrime(int number) {
        boolean result = true;
        if (number <= 1) {
            return false;
        }

        //n/2 because the largest factor of any number is either it's half or less than it
        //n/2, защото най-големият множител на всяко число е или половината, или по-малко от него
        for (int i = 2; i <= number / 2; i++) {

            //if some number divides it, then prime = false;
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
