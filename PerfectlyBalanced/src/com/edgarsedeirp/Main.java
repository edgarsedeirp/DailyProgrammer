package com.edgarsedeirp;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> stringList = readInputFromFile();

        for (String string : stringList) {
            System.out.println("\"" + string + "\"" + " => " + balanced(string));
        }
    }

    public static List<String> readInputFromFile(){
        List<String> inputFromFile = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(Paths.get("Input.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                inputFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputFromFile;
    }

    public static boolean balanced(String input){
       return (countOccurance(input, 'x') == countOccurance(input, 'y'));
    }

    public static int countOccurance(String input, char character){
        return (int) input.chars()
                .filter(c -> c == character)
                .count();
    }

}
