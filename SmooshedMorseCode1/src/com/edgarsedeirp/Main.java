package com.edgarsedeirp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    private final static String[] MORSE_CODE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public static void main(String[] args) {
	    List<String> inputFromFile = readInputFromFile("InputForInitialChallenge.txt");

	    inputFromFile.forEach(input -> {
            System.out.println("\"" + input + "\" => \"" + smorse(input) + "\"");
        });
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
