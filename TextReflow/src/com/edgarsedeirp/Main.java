package com.edgarsedeirp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> inputFromFile = readInputFromFile();
        int fromIndex = 0;

        for (int i = 0; i < inputFromFile.size(); i++) {
            if ((inputFromFile.get(i).isEmpty()) || (i == inputFromFile.size() - 1)) {
                List<String> subList = inputFromFile.subList(fromIndex, i + 1);
                subList.removeAll(Arrays.asList("", null));
                List<String> reflowJustified = justifyText(reflowText(subList));

                writeToFile(reflowJustified);

                fromIndex = i;
            }
        }
    }

    private static List<String> readInputFromFile() {
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

    private static List<String> reflowText(List<String> input) throws Exception {
        String[] arrayOfWords = input.toString().replace("[", "").replace("]", "").split(" "); //first convert List to array of words

        List<String> reflowedText = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int currentLineLength = 0;

        for (String arrayOfWord : arrayOfWords) {
            if (currentLineLength + arrayOfWord.length() <= 40) {     //Go through each word and if current line length is less than 40 - add word to line
                line.append(arrayOfWord).append(" ");
                currentLineLength += arrayOfWord.length() + 1;
            } else {                                                      //Else the line is added to List, and all variables are reset to initial values
                reflowedText.add(line.toString());
                line.setLength(0);
                line.append(arrayOfWord).append(" ");
                currentLineLength = line.length();
            }
        }
        reflowedText.add(line.toString());                            //Last line is added to List

        return reflowedText;
    }

    public static void writeToFile(List<String> reflowedText) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt", true));

        for (String string : reflowedText) {
            writer.append(string).append("\n");
        }
        writer.append("\n");

        writer.close();
    }

    public static List<String> justifyText(List<String> input) {

        List<String> result = new ArrayList<>();
        StringBuilder sb;

        for (String s : input) {
            int size = s.replace(" ", "").length();
            String[] arrayOfWords = s.split(" "); //first convert List to array of words

            while (size != 40) {
                for (int j = 0; j < arrayOfWords.length - 1; j++) {
                    sb = new StringBuilder(arrayOfWords[j]).append(" ");
                    arrayOfWords[j] = sb.toString();
                    size++;
                    if (size == 40) {
                        break;
                    }
                }
            }
            result.add(String.join("", arrayOfWords));
        }

        return result;
    }
}