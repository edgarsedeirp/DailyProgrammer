package com.edgarsedeirp;

import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> inputFromFile = readInputFromFile();
        int fromIndex = 0;

        for (int i=0; i<inputFromFile.size(); i++) {
            if( (inputFromFile.get(i).isEmpty()) || (i==inputFromFile.size() -1)) {
                List<String> subList = inputFromFile.subList(fromIndex, i+1);
                subList.removeAll(Arrays.asList("", null));
                defuseTheBomb(subList);
                fromIndex = i;
            }
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

    private static void defuseTheBomb(List<String> sublist){
        Queue<String> wireQue = new LinkedList<>(sublist);

        if(wiresCut(wireQue)){
            System.out.println("Bomb defused");
        }else{
            System.out.println("Boom");
        }
    }

    private static boolean wiresCut(Queue<String> wireQue) {
        boolean defused = true;

        while(!wireQue.isEmpty()){
            if(!defused){
                break;
            }

            String wireCut = wireQue.remove();

            if(wireCut.equalsIgnoreCase("white")){
                if(wireQue.peek() != null && (wireQue.peek().equalsIgnoreCase("white") || wireQue.peek().equalsIgnoreCase("black"))){
//                    System.out.println("If you cut a white cable you can't cut white or black cable.");
                    defused = false;
                }
            }else if(wireCut.equalsIgnoreCase("red")){
                if(wireQue.peek() != null && !wireQue.peek().equalsIgnoreCase("green")){
//                    System.out.println("If you cut a red cable you have to cut a green one");
                    defused = false;
                }
            }else if(wireCut.equalsIgnoreCase("black")){
                if(wireQue.peek() != null && (wireQue.peek().equalsIgnoreCase("white") || wireQue.peek().equalsIgnoreCase("green") || wireQue.peek().equalsIgnoreCase("orange"))){
//                    System.out.println("If you cut a black cable it is not allowed to cut a white, green or orange one");
                    defused = false;
                }
            }else if(wireCut.equalsIgnoreCase("orange")){
                if(wireQue.peek() != null && (!wireQue.peek().equalsIgnoreCase("red") && !wireQue.peek().equalsIgnoreCase("black")) ){
//                    System.out.println("If you cut a orange cable you should cut a red or black one");
                    defused = false;
                }
            }else if(wireCut.equalsIgnoreCase("green")){
                if(wireQue.peek() != null && (!wireQue.peek().equalsIgnoreCase("orange") && !wireQue.peek().equalsIgnoreCase("white"))){
//                    System.out.println("If you cut a green one you have to cut a orange or white one");
                    defused = false;
                }
            }else if(wireCut.equalsIgnoreCase("purple")){
                if(wireQue.peek() != null && (wireQue.peek().equalsIgnoreCase("purple") || wireQue.peek().equalsIgnoreCase("green") || wireQue.peek().equalsIgnoreCase("orange") || wireQue.peek().equalsIgnoreCase("white"))){
//                    System.out.println("If you cut a purple cable you can't cut a purple, green, orange or white cable");
                    defused = false;
                }
            }
        }
        return defused;
    }
}
