package day3;

public class Main {
    public static void main(String[] args) {
        Day3 day3 = new Day3();
        day3.readInput();

        double sum = day3.calculateMemoryMultiplicationSum();
        System.out.println("Sum: " + sum);

        double newSum = day3.calculateMemoryMultiplicationSumWithNewInstructions();
        System.out.println("Sum: " + newSum);
    }
}
