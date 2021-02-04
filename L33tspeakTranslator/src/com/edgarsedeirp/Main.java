package com.edgarsedeirp;

import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    private final static String[] standartAlphabet = {"A","B","E","I","L","M","N","O","S","T","V","W"};
    private final static String[] leetAlphabet = {"4","6","3","1","|","(V)","(\\)","0","5","7","\\/","`//"};

    public static void main(String[] args) {
        List<String> inputFromFile = readInputFromFile();
        String translatedWord;

        for (String originalWord: inputFromFile) {
            if(containsOnlyLettersAndPunctuation(originalWord)) {
                translatedWord = translateToLeetSpeak(originalWord.toLowerCase());
            }else{
                translatedWord = translateFromLeetSpeak(originalWord.toLowerCase());
            }
            System.out.println(originalWord + " -> " + translatedWord);
        }
    }

    private static List<String> readInputFromFile(){
        List<String> inputList = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("Input.txt"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                inputList.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return inputList;
    }

    private static boolean containsOnlyLettersAndPunctuation(String wordToCheck){
        return Pattern.matches("[A-Za-z ?.!]*", wordToCheck);
    }

    private static String translateToLeetSpeak(String word){
        for (int i = 0; i < standartAlphabet.length; i++) {
            word = word.replace(standartAlphabet[i].toLowerCase(),leetAlphabet[i]);
        }

        return word.toUpperCase();
    }

    private static String translateFromLeetSpeak(String word){
        for (int i = 0; i < leetAlphabet.length; i++) {
            word = word.replace(leetAlphabet[i], standartAlphabet[i].toLowerCase());
        }

        return word.substring(0,1).toUpperCase() + word.substring(1);
    }

}
