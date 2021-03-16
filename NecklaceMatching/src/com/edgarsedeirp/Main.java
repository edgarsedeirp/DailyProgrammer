package com.edgarsedeirp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<List<String>> inputList = readInputFromFile();
        for (List<String> input : inputList) {
            System.out.println(input.get(0) + " => " + input.get(1) + " : " + same_necklace(input.get(0), input.get(1)));
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
}
