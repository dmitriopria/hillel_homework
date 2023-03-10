package homework4;

public class String2_5 {

    public static void main(String[] args) {

        System.out.println(wordEnds("HelloWorld", "lo"));
        System.out.println(doubleChar("Hello"));
        System.out.println(sameStarChar("xy*yzz"));
        System.out.println(getSandwich("xxbreadjambreadyy"));
        System.out.println(zipZap("zzzopzop"));

    }

    /* Given a string and a non-empty word string, return a string made of each char
    just before and just after every appearance of the word in the string.
    Ignore cases where there is no char before or after the word, and a char
    may be included twice if it is between two words. */
    public static String wordEnds(String str, String word) {
        int wordLength = word.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length() - wordLength + 1; i++) {
            if (str.substring(i, i + wordLength).equals(word)) {
                if (i > 0) {
                    result.append(str.charAt(i - 1));
                }
                if (i + wordLength < str.length()) {
                    result.append(str.charAt(i + wordLength));
                }
            }
        }
        return result.toString();
    }

    /* Given a string, return a string where for every char in the original,
    there are two chars. */
    public static String doubleChar(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i));
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    /* Returns true if for every '*' (star) in the string, if there are chars
    both immediately before and after the star, they are the same. */
    public static boolean sameStarChar(String str) {
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '*' && str.charAt(i - 1) != str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /* A sandwich is two pieces of bread with something in between. Return the string
    that is between the first and last appearance of "bread" in the given string, or
    return the empty string "" if there are not two pieces of bread. */
    public static String getSandwich(String str) {
        int start = str.indexOf("bread");
        int end = str.lastIndexOf("bread");
        if (start == end) {
            return "";
        } else {
            return str.substring(start + 5, end);
        }
    }

    /* Look for patterns like "zip" and "zap" in the string -- length-3, starting
    with 'z' and ending with 'p'. Return a string where for all such words,
    the middle letter is gone, so "zipXzap" yields "zpXzp". */
    public static String zipZap(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i + 2 < str.length() && str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                sb.append("zp");
                i += 2;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
