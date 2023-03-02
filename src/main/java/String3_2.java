public class String3_2 {

    public static void main(String[] args) {

        System.out.println(countTriple("xxxabyyyycd"));
        System.out.println(maxBlock("abbCCCddBBBxx"));

    }

    /* We'll say that a "triple" in a string is a char appearing three times in a row.
    Return the number of triples in the given string. The triples may overlap. */
    public static int countTriple(String str) {
        int counter = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2))
                counter++;
        }
        return counter;
    }

    /* Given a string, return the length of the largest "block" in the string.
    A block is a run of adjacent chars that are the same. */
    public static int maxBlock(String str) {
        int max = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 1;
            }
        }
        if (count > max && str.length() > 0) {
            max = count;
        }
        return max;
    }

}
