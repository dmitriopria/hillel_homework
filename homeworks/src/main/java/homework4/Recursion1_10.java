package homework4;

public class Recursion1_10 {

    public static void main(String[] args) {

        System.out.println(factorial(3));
        System.out.println(bunnyEars(5));
        System.out.println(fibonacci(5));
        System.out.println(changeXY("xxhixx"));
        int[] a = {1, 6, 4};
        System.out.println(array6(a, 0));
        System.out.println(allStar("hello"));
        System.out.println(countPairs("axax"));
        System.out.println(stringClean("aacbbxdff"));
        System.out.println(nestParen("((()))"));
        System.out.println(strDist("hellodimahelloworld", "hello"));

    }

    /* Given n of 1 or more, return the factorial of n, which is
    n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops). */
    public static int factorial(int n) {
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    /*
    We have a number of bunnies and each bunny has two big floppy ears.
    We want to compute the total number of ears across all the bunnies recursively
    (without loops or multiplication). */
    public static int bunnyEars(int bunnies) {
        if (bunnies == 0) return 0;
        else return 2 + bunnyEars(bunnies - 1);
    }

    /* The fibonacci sequence is a famous bit of mathematics, and it happens to have a
    recursive definition. The first two values in the sequence are 0 and 1
    (essentially 2 base cases). Each subsequent value is the sum of the previous
    two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
    Define a recursive fibonacci(n) method that returns the nth fibonacci number,
    with n=0 representing the start of the sequence. */
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /* Given a string, compute recursively (no loops) a new string where all the
    lowercase 'x' chars have been changed to 'y' chars. */
    public static String changeXY(String str) {
        if (str.isEmpty()) return str;
        else if (str.charAt(0) == 'x') return 'y' + changeXY(str.substring(1));
        else return str.charAt(0) + changeXY(str.substring(1));
    }

    /* Given an array of ints, compute recursively if the array contains a 6.
    We'll use the convention of considering only the part of the array that begins
    at the given index. In this way, a recursive call can pass index+1 to move
    down the array. The initial call will pass in index as 0. */
    public static boolean array6(int[] nums, int index) {
        if (index >= nums.length) {
            return false;
        } else if (nums[index] == 6) {
            return true;
        } else {
            return array6(nums, index + 1);
        }
    }

    /* Given a string, compute recursively a new string where all the adjacent
    chars are now separated by a "*". */
    public static String allStar(String str) {
        if (str.length() <= 1) {
            return str;
        } else {
            return str.charAt(0) + "*" + allStar(str.substring(1));
        }
    }

    /* We'll say that a "pair" in a string is two instances of a char separated
    by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains
    3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs
    in the given string. */
    public static int countPairs(String str) {
        if (str.length() <= 2) {
            return 0;
        } else if (str.charAt(0) == str.charAt(2)) {
            return 1 + countPairs(str.substring(1));
        } else {
            return countPairs(str.substring(1));
        }
    }

    /* Given a string, return recursively a "cleaned" string where adjacent chars
    that are the same have been reduced to a single char. So "yyzzza" yields "yza". */
    public static String stringClean(String str) {
        if (str.length() <= 1) {
            return str;
        } else if (str.charAt(0) == str.charAt(1)) {
            return stringClean(str.substring(1));
        } else {
            return str.charAt(0) + stringClean(str.substring(1));
        }
    }

    /* Given a string, return true if it is a nesting of zero or more pairs of
    parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars,
    and then recur on what's inside them. */
    public static boolean nestParen(String str) {
        if (str.equals("")) {
            return true;
        } else if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            return nestParen(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }

    /* Given a string and a non-empty substring sub, compute recursively the
    largest substring which starts and ends with sub and return its length. */
    public static int strDist(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        } else if (str.startsWith(sub)) {
            if (str.endsWith(sub)) {
                return str.length();
            } else {
                return strDist(str.substring(0, str.length() - 1), sub);
            }
        } else {
            return strDist(str.substring(1), sub);
        }
    }

}
