package com.edgarsedeirp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> challengeInput = readInputFromFile("ChallengeInput.txt");

        for (String input : challengeInput) {
            System.out.println("Index of first recurring char : " + firstRecurringCharacter(input) + "\n");
        }
    }

    public static List<String> readInputFromFile(String filename){
        List<String> inputList = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(filename))){
            while (scanner.hasNextLine()){
                inputList.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputList;
    }

    public static int firstRecurringCharacter(String input){
        char[] inputToCharArray = input.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<>();
        int counter = 0;

        for (char character : inputToCharArray) {
            if(charMap.containsKey(character)){
                System.out.println("Input : \"" + input + "\" first recurring character : " + character);
                return charMap.get(character);
            }else{
                charMap.put(character, counter);
                counter++;
            }
        }

        return -1;
    }
}
