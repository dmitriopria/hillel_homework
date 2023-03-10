package homework5;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Homework_number5 {

    public static void main(String[] args) {

        System.out.println(findSymbolOccurrence("abbccc", 'c'));
        System.out.println(findWordPosition("aaabbmmm", "bbb"));
        System.out.println(reverseStringCheating("Hello"));
        System.out.println(reverseString("Hello"));
        System.out.println(isPalindrome("abccba"));

        Homework_number5.playGame();

    }

    /* Створити метод findSymbolOccurrence. Метод приймає як параметр рядок і символ.
    Необхідно обчислити, скільки разів символ зустрічається в переданому рядку
    і повернути це числове значення. */
    public static int findSymbolOccurrence(String inputString, char inputChar) {
        Objects.requireNonNull(inputString);
        int counter = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == inputChar) {
                counter++;
            }
        }
        return counter;
    }

    /* Створити метод findWordPosition. Метод приймає як параметри
    два рядки (source, target). Необхідно з'ясувати, чи є target (підрядок)
    частиною рядка source. Якщо так, тоді повернути номер позиції (індекс)
    першого елемента підрядка у рядку, інакше повернути -1. */
    public static int findWordPosition(String source, String target) {
        Objects.requireNonNull(source);
        Objects.requireNonNull(target);
        return source.indexOf(target);
    }

    /* Створити метод stringReverse. Метод приймає як параметр - рядок.
    Необхідно її розгорнути та повернути змінений варіант. */
    public static String reverseStringCheating(String inputString) {
        Objects.requireNonNull(inputString);
        return "\u202E" + inputString;
    }

    public static String reverseString(String inputString) {
        Objects.requireNonNull(inputString);
        String reversedInput = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            reversedInput += inputString.charAt(i);
        }
        return reversedInput;
    }

    /* Створити метод isPalindrome. Метод приймає як параметр - рядок.
    Необхідно Перевірити, чи є переданий рядок паліндромом.
    Якщо так, тоді повернуть true, інакше false. */
    public static boolean isPalindrome(String inputString) {
        Objects.requireNonNull(inputString);
        int leftIndex = 0;
        int rightIndex = inputString.length() - 1;
        while (leftIndex < rightIndex) {
            if (inputString.charAt(leftIndex) != inputString.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    /* Створити масив зі слів String[] words = {"apple", "orange", "lemon", "banana",
    "apricot", "avocado" , "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
    "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear",
    "pepper", "pineapple", "pumpkin", "potato"};
    При запуску програми комп'ютер загадує слово, запитує відповідь у користувача,
    порівнює його із загаданим словом та повідомляє чи правильно відповів користувач.
    Якщо слово не вгадано, комп'ютер показує літери, які стоять на своїх місцях.
    apple – загадане apricot - відповідь гравця
    ap############# (15 символів, щоб користувач не міг дізнатися довжину слова)
    Для порівняння двох слів посимвольно, можна скористатися:
    String str = "apple";
    str.charAt(0); - метод, поверне char, який стоїть у слові str на першій позиції
    Граємо до тих пір, поки гравець не відгадає слово
    Використовуємо лише маленькі літери */

    /**
     * Initialization and realization of this game are all in one methode.
     * I could do separation of code, but I did all in one to make it easy readable
     * for you on GitHub.
     * Additionally, I have printed the words to make the game easier for player.
     **/
    public static void playGame() {
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        System.out.println(Arrays.toString(words));

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];
        String guess = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("I think the word from above array, try to guess this word");

        while (!guess.equals(secretWord)) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextLine().toLowerCase();

            if (guess.equals(secretWord)) {
                System.out.println("Congratulation, you win!!!");
            } else {
                String hint = "";
                for (int i = 0; i < 15; i++) {
                    if (i < guess.length() && i < secretWord.length() && guess.charAt(i) == secretWord.charAt(i)) {
                        hint += guess.charAt(i);
                    } else if (i >= secretWord.length() && i < 15) {
                        hint += "#";
                    } else
                        hint += "#";
                }
                System.out.println("Wrong answer. Here's a hint: " + hint);
            }
        }
    }


}