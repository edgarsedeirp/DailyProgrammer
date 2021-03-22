import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> inputFromFile = readInputFromFile();

        inputFromFile.forEach( input -> {
            System.out.println(upc(input));
        });

    }

    private static int upc(String input){
        char[] inputToCharArray = input.toCharArray();
        int evenSum = Integer.parseInt(String.valueOf(inputToCharArray[0]));
        int oddSum = Integer.parseInt(String.valueOf(inputToCharArray[1]));

        //Sum the digits at odd-numbered and even-numbered positions
        for (int i = 2; i < inputToCharArray.length; i++) {
            int value = Integer.parseInt(String.valueOf(inputToCharArray[i]));
            if(i % 2 == 0){
                evenSum += value;
            }else{
                oddSum += value;
            }
        }

        //Multiply the eve-number sum by 3 and add odd-numbered sum
        int checkDigit = evenSum * 3 + oddSum;

        //If M is 0, then the check digit is 0; otherwise the check digit is 10 - M.
        return (checkDigit % 10 == 0) ? 0 : (10 - (checkDigit % 10)) ;
    }

    private static List<String> readInputFromFile(){
        List<String> inputFromFile = new ArrayList<>();

        try(Scanner scanner = new Scanner(Paths.get("Input.txt"))) {
            while(scanner.hasNextLine()){
                String row = scanner.nextLine().trim();
                //input needs to be 11 digits
                if(row.length() < 11){
                    char[] repeat = new char[11 - row.length()];
                    Arrays.fill(repeat, '0');
                    row = new String(repeat) + row;
                }
                inputFromFile.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputFromFile;
    }
}
