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
            int counter = 0;
            while(value.length() > 1)  {
                int sum = 0;
                counter++;

                for(int i=0; i<value.length(); i++){
                    sum += Integer.parseInt(String.valueOf(value.charAt(i)));
                }
                value = String.valueOf(sum);
            }
            resultToReturn.add(counter);
        }

        return resultToReturn;
    }
}
