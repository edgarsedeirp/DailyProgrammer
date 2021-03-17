package com.edgarsedeirp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<List<String>> inputList = readInputFromFile();
        List<String> bonusList = new ArrayList<>(Arrays.asList("abc", "abcabcabc", "abcabcabcx", "aaaaaa", "a", ""));
        for (List<String> input : inputList) {
            System.out.println(input.get(0) + " => " + input.get(1) + " : " + same_necklace(input.get(0), input.get(1)));
        }
        System.out.println("------------BONUS----------------");
        for (String string : bonusList) {
            System.out.println("\"" + string + "\"" + " => " + repeats(string));
        }
    }

    public static List<List<String>> readInputFromFile(){
        List<List<String>> inputList = new ArrayList<List<String>>();

        try {
            Scanner scanner = new Scanner(Paths.get("Input.txt"));
            while(scanner.hasNextLine()){
                String row = scanner.nextLine();
                String[] splitInput = row.split(",");
                inputList.add(Arrays.asList(splitInput));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputList;
    }

    public static boolean same_necklace(String inputOne, String inputTwo){
        int numberOfAttempts = inputOne.length();
        StringBuilder inputOneBuilder = new StringBuilder(inputOne);

        if(inputOne.length() != inputTwo.length()){
            return false;
        }

        while(numberOfAttempts > 0){
            if(inputOneBuilder.toString().equals(inputTwo)){
                return true;
            }
            inputOneBuilder.append(inputOneBuilder.charAt(0));
            inputOneBuilder = new StringBuilder(inputOneBuilder.substring(1));
            numberOfAttempts--;
        }

        return false;
    }

    public static int repeats(String input){
        int count = 0;
        int numberOfAttempts = input.length();
        StringBuilder inputBuilder = new StringBuilder(input);

        if(input.length() <= 1){
            return 1;
        }

        while(numberOfAttempts > 0){
            inputBuilder.append(inputBuilder.charAt(0));
            inputBuilder = new StringBuilder(inputBuilder.substring(1));
            numberOfAttempts--;
            if(input.equals(inputBuilder.toString())){
                count++;
            }
        }

        return count;
    }
}
