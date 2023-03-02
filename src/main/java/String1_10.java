public class String1_10 {

    public static void main(String[] args) {

        System.out.println(withoutX2("Hexllo"));
        System.out.println(deFront("away"));
        System.out.println(minCat("Hello", "Hi"));
        System.out.println(lastTwo("Hello World of Java"));
        System.out.println(atFirst("aBcd"));
        System.out.println(twoChar("Hello", 2));
        System.out.println(middleTwo("Hello!"));
        System.out.println(right2("JavaHi"));
        System.out.println(comboString("Dima", "Hello"));
        System.out.println(firstTwo("paper"));

    }

    /* Given a string, if one or both of the first 2 chars is 'x', return the string
    without those 'x' chars, and otherwise return the string unchanged.
    This is a little harder than it looks. */
    public static String withoutX2(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i < 2 && str.charAt(i) == 'x') {
                continue;
            }
            result += str.charAt(i);
        }
        return result;
    }

    /* Given a string, return a version without the first 2 chars.
    Except keep the first char if it is 'a' and keep the second char if it is 'b'.
    The string may be any length. Harder than it looks. */
    public static String deFront(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) != 'a' || i == 1 && str.charAt(1) != 'b') {
                continue;
            }
            result += str.charAt(i);
        }
        return result;
    }

    /* Given two strings, append them together (known as "concatenation") and return
     the result. However, if the strings are different lengths, omit chars from
     the longer string so it is the same length as the shorter string.
     So "Hello" and "Hi" yield "loHi". The strings may be any length. */
    public static String minCat(String a, String b) {
        String result = "";
        if (a.length() > b.length()) {
            result = a.substring(a.length() - b.length()) + b;
        } else if (a.length() < b.length()) {
            result = a + b.substring(b.length() - a.length());
        } else result = a + b;
        return result;
    }

    /* Given a string of any length, return a new string where the last 2 chars,
    if present, are swapped, so "coding" yields "codign". */
    public static String lastTwo(String str) {
        if (str.length() < 2) {
            return str;
        }
        char lastChar = str.charAt(str.length() - 1);
        char secondLastChar = str.charAt(str.length() - 2);
        return str.substring(0, str.length() - 2) + lastChar + secondLastChar;
    }

    /* Given a string, return a string length 2 made of its first 2 chars.
    If the string length is less than 2, use '@' for the missing chars. */
    public static String atFirst(String str) {
        if (str.length() >= 2) {
            return str.substring(0, 2);
        } else if (str.length() == 1) {
            return str + '@';
        } else
            return "@@";
    }

    /* Given a string and an index, return a string length 2 starting at the given index.
    If the index is too big or too small to define a string length 2,
    use the first 2 chars. The string length will be at least 2. */
    public static String twoChar(String str, int index) {
        if (index > str.length() - 2 || index < 0) {
            return str.substring(0, 2);
        } else
            return str.substring(index, index + 2);
    }

    /* Given a string of even length, return a string made of the middle two chars,
    so the string "string" yields "ri". The string length will be at least 2. */
    public static String middleTwo(String str) {
        return str.substring(str.length() / 2 - 1, str.length() / 2 + 1);
    }

    /* Given a string, return a "rotated right 2" version where the last 2 chars
    are moved to the start. The string length will be at least 2. */
    public static String right2(String str) {
        String end = str.substring(str.length() - 2, str.length());
        String start = str.substring(0, str.length() - 2);
        return end + start;
    }

    /* Given 2 strings, a and b, return a string of the form short+long+short, with
    the shorter string on the outside and the longer string on the inside.
    The strings will not be the same length, but they may be empty (length 0). */
    public static String comboString(String a, String b) {
        if (a.length() > b.length()) {
            return b + a + b;
        } else
            return a + b + a;
    }

    /* Given a string, return the string made of its first two chars, so the String
    "Hello" yields "He". If the string is shorter than length 2, return whatever
    there is, so "X" yields "X", and the empty string "" yields the empty string "".
    Note that str.length() returns the length of a string. */
    public static String firstTwo(String str) {
        if (str.length() > 2) {
            return str.substring(0, 2);
        } else
            return str;
    }

}
