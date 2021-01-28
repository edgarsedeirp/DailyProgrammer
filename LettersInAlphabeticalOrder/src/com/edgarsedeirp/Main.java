package com.edgarsedeirp;

import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> userInputList = readInputFromFile();

        for (String originalString : userInputList) {
            if (isStringInOrder(originalString)) {
                System.out.println(originalString + " IN ORDER");
            } else if (isStringReversed(originalString)) {
                System.out.println(originalString + " REVERSE ORDER");
            } else {
                System.out.println(originalString + " NOT IN ORDER");
            }
        }
    }

    private static List<String> readInputFromFile() {
        List<String> userInputList = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("Input.txt"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                userInputList.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return userInputList;
    }

    private static boolean isStringInOrder(String input) {
        char[] stringToCheck = input.toCharArray();
        Arrays.sort(stringToCheck);

        return (input.equals(new String(stringToCheck)));
    }

    private static boolean isStringReversed(String input) {
        String reversedString = new StringBuilder(input).reverse().toString();
        char[] stringToCheck = reversedString.toCharArray();

        Arrays.sort(stringToCheck);

        return (reversedString.equals(new String(stringToCheck)));
    }
}
