package Strings;

import java.util.ArrayList;
import java.util.List;

public class PrefixSearch {
    public static List<Integer> findPrefixIndexes(String str, String prefix) {
        List<Integer> indexes = new ArrayList<>();
        int prefixLength = prefix.length();

        for (int i = 0; i <= str.length() - prefixLength; i++) {
            // Check if the substring starting at index i matches the prefix
            if (str.startsWith(prefix, i)) {
                indexes.add(i); // If it matches, add the index to the list
            }
        }

        return indexes;
    }

    public static void main(String[] args) {
        String str = "This is a test string, testing string operations.";
        String prefix = "test";
        List<Integer> indexes = findPrefixIndexes(str, prefix);
        System.out.println("Indexes of prefix '" + prefix + "': " + indexes);
    }
}

