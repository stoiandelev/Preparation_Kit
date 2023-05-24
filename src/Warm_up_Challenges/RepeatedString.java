package Warm_up_Challenges;

public class RepeatedString {
    public static void main(String[] args) {

        String s = "aba";
        long n = 10;

        long count = s.chars().filter(ch -> ch == 'a').count();

        long remainderOfString = n % s.length();

        long repeatString = n / s.length();

        long assemblyString = s.substring(0, (int) (remainderOfString)).chars().filter(ch -> ch == 'a').count();

        System.out.println(count * repeatString + assemblyString);
    }
}
