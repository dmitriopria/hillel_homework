package hw14;

import java.util.*;

public class ArrayImplementer {
    public static List createList() {
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("date");
        words.add("elderberry");
        return words;
    }

    public static int countOccurrence(List<String> words, String word) {
        int count = 0;
        for (String str : words) {
            if (str.equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static Map<String, Integer> calcOccurrence(List<String> words) {
        Map<String, Integer> occurrence = new HashMap<>();
        for (String word : words) {
            if (occurrence.containsKey(word)) {
                occurrence.put(word, occurrence.get(word) + 1);
            } else {
                occurrence.put(word, 1);
            }
        }
        return occurrence;
    }

    public static <E> List<E> toList(E[] array) {
        List<E> list = new ArrayList<>(array.length);
        list.addAll(Arrays.asList(array));
        return list;
    }

    public static Set<Integer> findUnique(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }

    public static List<WordOccurrence> findOccurrence(List<String> words) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : words) {
            if (occurrenceMap.containsKey(word)) {
                occurrenceMap.put(word, occurrenceMap.get(word) + 1);
            } else {
                occurrenceMap.put(word, 1);
            }
        }
        List<WordOccurrence> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            WordOccurrence wordOccurrence = new WordOccurrence(entry.getKey(), entry.getValue());
            result.add(wordOccurrence);
        }
        return result;
    }

}
