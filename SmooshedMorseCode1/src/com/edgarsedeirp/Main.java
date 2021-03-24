package com.edgarsedeirp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private final static String[] MORSE_CODE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static void main(String[] args) {
	    List<String> inputFromFile = readInputFromFile("InputForInitialChallenge.txt");

	    inputFromFile.forEach(input -> {
            System.out.println("\"" + input + "\" => \"" + smorse(input) + "\"");
        });

        System.out.println("----------------------BONUS----------------------");
        smorseBonus();
    }

    private static String smorse(String input){
        char[] inputCharArray = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (char character : inputCharArray) {
            if(character >= 'a' && character <= 'z'){
                stringBuilder.append(MORSE_CODE[(int) character - 97]);
            }
        }

        return stringBuilder.toString();
    }

    private static void smorseBonus(){
        List<String> veryLargeInputFromFile = readInputFromFile("InputForBonusChallenge.txt");

        List<String> veryLargeInputToMorse = veryLargeInputFromFile.stream()
                .map(Main::smorse)
                .collect((Collectors.toList()));

        //Solution to Bonus 1.
        Map<String, Long> frequencyMap =
                veryLargeInputToMorse.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Solution to bonus 1 : " + getKeyFromValue(frequencyMap, 13L));

    }

    private static String getKeyFromValue(Map<String, Long> map, Long value) {
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static List<String> readInputFromFile(String filename){
        List<String> inputFromFile = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get(filename))){
            while (scanner.hasNextLine()){
                inputFromFile.add(scanner.nextLine().trim().toLowerCase(Locale.ROOT));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputFromFile;
    }
}
