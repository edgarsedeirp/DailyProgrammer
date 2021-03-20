package com.edgarsedeirp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) {
        List<String> initialChallangeInputList = readInputFromFile("InitialChallangeInput.txt");
        List<String> bonusChallangeInputList = readInputFromFile("BonusChallangeInput.txt");

        initialChallangeInputList.forEach(input -> {
            System.out.println("\"" + input + "\"" + " => " + balanced(input));
        });

        System.out.println("---------------------BONUS CHALLANGE---------------------");

        bonusChallangeInputList.forEach(input -> {
            System.out.println("\"" + input + "\"" + " => " + balanced_bonus(input));
        });

    }

    public static List<String> readInputFromFile(String filename) {
        List<String> inputFromFile = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(Paths.get(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                inputFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputFromFile;
    }

    public static boolean balanced_bonus(String input) {
        Map<Character, Integer> frequencies = input.chars().boxed()
                .collect(toMap(k -> (char) k.intValue(),
                        v -> 1,             //1 occurance
                        Integer::sum));

        int[] result = frequencies.values().stream()
                .mapToInt(Integer::intValue)
                .toArray();

        int valueToCheck = result[0];
        for (int i = 1; i < result.length; i++) {
            if(valueToCheck != result[i]){
                return false;
            }
        }

        return true;
    }

    public static boolean balanced(String input) {
        return (countOccurance(input, 'x') == countOccurance(input, 'y'));
    }

    public static int countOccurance(String input, char character) {
        return (int) input.chars()
                .filter(c -> c == character)
                .count();
    }
}
