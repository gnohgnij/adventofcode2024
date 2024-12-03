package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    private String memory = "";

    public void readInput() {
        try {
            File input = new File("day3/input.txt");
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                this.memory += sc.nextLine();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public double calculateMemoryMultiplicationSum() {
        String regexPattern = "mul\\((\\d+),(\\d+)\\)";

        Pattern compiledPattern = Pattern.compile(regexPattern);
        Matcher matcher = compiledPattern.matcher(this.memory);

        double sum = 0;

        while(matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            sum += x * y;
        }
        
        return sum;
    }

    public double calculateMemoryMultiplicationSumWithNewInstructions() {
        String regexPattern = "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don\\'t\\(\\)";

        Pattern compiledPattern = Pattern.compile(regexPattern);
        Matcher matcher = compiledPattern.matcher(this.memory);

        double sum = 0;
        boolean mulEnabled = true;

        while(matcher.find()) {
            if(matcher.group().equals("don't()")) {
                mulEnabled = false;
            } else if(matcher.group().equals("do()")) {
                mulEnabled = true;
            } else if(mulEnabled) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                sum += x * y;
            }
        }
        
        return sum;
    }

    public void printMemory() {
        System.out.println(this.memory);
    }
}
