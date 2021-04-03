package com.edgarsedeirp;

import java.util.*;

public class Main {

    private static Map<String, String> morseHashMap;
    static{
        morseHashMap = new LinkedHashMap<>();
        morseHashMap.put("-...", "b");
        morseHashMap.put("-.-.", "c");
        morseHashMap.put("..-.", "f");
        morseHashMap.put("....", "h");
        morseHashMap.put(".---", "j");
        morseHashMap.put(".-..", "l");
        morseHashMap.put(".--.", "p");
        morseHashMap.put("--.-", "q");
        morseHashMap.put("...-", "v");
        morseHashMap.put("-..-", "x");
        morseHashMap.put("-.--", "y");
        morseHashMap.put("--..", "z");
        morseHashMap.put("-..", "d");
        morseHashMap.put("--.", "g");
        morseHashMap.put("-.-", "k");
        morseHashMap.put("---", "o");
        morseHashMap.put(".-.", "r");
        morseHashMap.put("...", "s");
        morseHashMap.put(".-", "a");
        morseHashMap.put("..-", "u");
        morseHashMap.put(".--", "w");
        morseHashMap.put("..", "i");
        morseHashMap.put("--", "m");
        morseHashMap.put("-.", "n");
        morseHashMap.put(".", "e");
        morseHashMap.put("-", "t");
    }

    public static void main(String[] args) {
        String[] challangeInput = new String[]{".--...-.-.-.....-.--........----.-.-..---.---.--.--.-.-....-..-...-.---..--.----..", ".----...---.-....--.-........-----....--.-..-.-..--.--...--..-.---.--..-.-...--..-", "..-...-..-....--.---.---.---..-..--....-.....-..-.--.-.-.--.-..--.--..--.----..-.."};

        for (String input: challangeInput) {
            System.out.println(input + " => " + smalpha(input));
        }
    }

    private static String smalpha(String morseCodeToConvert){
        StringBuilder convertedMorseCode = new StringBuilder();
        List<String> usedValueList = new ArrayList<>();

        while (convertedMorseCode.length() != 26) {

            for (String key : morseHashMap.keySet()) {
                for (int i = 0; i < morseCodeToConvert.length(); i++) {
                    if (morseCodeToConvert.startsWith(key, i) && !usedValueList.contains(morseHashMap.get(key))) {
                        convertedMorseCode.append(morseHashMap.get(key));
                        usedValueList.add(morseHashMap.get(key));
                        morseCodeToConvert = morseCodeToConvert.substring(key.length());
                    }
                }

            }

            shuffleMap(morseHashMap);
        }
        return convertedMorseCode.toString();
    }

    public static void shuffleMap(Map<String,String> map) {
        List<String> valueList = new ArrayList<>(map.values());

        Collections.shuffle(valueList);
        Iterator<String> valueIt = valueList.iterator();

        for(Map.Entry<String,String> e : map.entrySet()) {
            e.setValue(valueIt.next());
        }
    }
}
