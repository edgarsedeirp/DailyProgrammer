package com.edgarsedeirp;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    List<String> inputList = readInputFromFile();

        List<Integer> result = calculateAdditivePersistance(inputList);
        System.out.println(result);
    }



    private static List<String> readInputFromFile() {
        List<String> inputList = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get("Input.txt"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine().replaceAll("\\D", "");  //Replaces all non numeric values with ""
                inputList.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return inputList;
    }

    private static List<Integer> calculateAdditivePersistance(List<String> input){
        List<Integer> resultToReturn = new ArrayList<>();

        for (String value : input ) {
            int sum, i;
            sum = i = 0;
            boolean validResult = false;
            char[] valueAsCharArray = value.toCharArray();

            for (char c : valueAsCharArray) {
                sum += Character.getNumericValue(c);
            }

            while(!validResult){
                i++;
                if(sum < 10){
                    validResult = true;
                    resultToReturn.add(i);
                }
                sum = (sum % 10) + (sum / 10);
            }
        }

        return resultToReturn;
    }
}
