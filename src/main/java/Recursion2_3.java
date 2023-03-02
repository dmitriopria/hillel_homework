public class Recursion2_3 {

    public static void main(String[] args) {

        int[] a = {2, 5, 10, 4};
        System.out.println(splitOdd10(a));
        System.out.println(split53(a));
        System.out.println(groupNoAdj(0, a, 12));

    }

    /* Given an array of ints, is it possible to divide the ints into two groups,
    so that the sum of one group is a multiple of 10, and the sum of the other
    group is odd. Every int must be in one group or the other. Write a recursive helper
    method that takes whatever arguments you like, and make the initial call to your
    recursive helper from splitOdd10(). (No loops needed. */
    public static boolean splitOdd10(int[] nums) {
        return splitOdd10Helper(nums, 0, 0, 0);
    }

    private static boolean splitOdd10Helper(int[] nums, int index, int sum1, int sum2) {
        if (index >= nums.length) {
            return sum1 % 10 == 0 && sum2 % 2 == 1;
        }

        return splitOdd10Helper(nums, index + 1, sum1 + nums[index], sum2) ||
                splitOdd10Helper(nums, index + 1, sum1, sum2 + nums[index]);
    }

    /* Given an array of ints, is it possible to divide the ints into two groups,
    so that the sum of the two groups is the same, with these constraints:
    all the values that are multiple of 5 must be in one group, and all the values
    that are a multiple of 3 (and not a multiple of 5) must be in the other.
    (No loops needed.) */

    public static boolean split53(int[] nums) {
        return split53Helper(nums, 0, 0, 0);
    }

    private static boolean split53Helper(int[] nums, int index, int sum5, int sum3) {
        if (index == nums.length) {
            return sum5 == sum3;
        }

        int value = nums[index];
        if (value % 5 == 0) {
            return split53Helper(nums, index + 1, sum5 + value, sum3);
        } else if (value % 3 == 0) {
            return split53Helper(nums, index + 1, sum5, sum3 + value);
        } else {
            return split53Helper(nums, index + 1, sum5 + value, sum3) ||
                    split53Helper(nums, index + 1, sum5, sum3 + value);
        }
    }

    /* Given an array of ints, is it possible to choose a group of some of the ints,
     such that the group sums to the given target with this additional constraint:
     If a value in the array is chosen to be in the group, the value immediately
     following it in the array must not be chosen. (No loops needed.) */
    public static boolean groupNoAdj(int start, int[] nums, int target) {
        if (target == 0) {
            return true;
        }
        if (start >= nums.length) {
            return false;
        }
        if (groupNoAdj(start + 2, nums, target - nums[start])) {
            return true;
        }
        if (groupNoAdj(start + 1, nums, target)) {
            return true;
        }
        return false;
    }

}
