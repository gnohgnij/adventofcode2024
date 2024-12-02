package day2;

public class Main {
    public static void main(String[] args) {
        Day2 day2 = new Day2();
        day2.readInput();

        int safeReportCount = day2.countSafeReports(false);
        System.out.println("Total Number of Safe Reports: " + safeReportCount);

        int safeReportCountWithDampener = day2.countSafeReports(true);
        System.out.println("Total Number of Safe Reports (Using Dampener): " + safeReportCountWithDampener);
    }
}
