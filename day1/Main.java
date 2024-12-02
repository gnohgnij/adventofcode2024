package day1;

public class Main {

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        day1.readInput();

        day1.sortLists();

        int totalDistance = day1.calculateDistance();
        System.out.println("Total distance: " + totalDistance);

        int similarity = day1.calculateSimilarity();
        System.out.println("Similarity Score: " + similarity);
    }
}