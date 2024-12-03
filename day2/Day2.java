package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    private List<List<Integer>> list;

    public Day2() {
        this.list = new ArrayList<>();
    }

    public void readInput() {
        try {
            File input = new File("day2/input.txt");
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                String reports = sc.nextLine();
                String[] split = reports.split(" ");
                List<Integer> arr = new ArrayList<>();
                for(String s : split) {
                    arr.add(Integer.parseInt(s));
                }
                this.list.add(arr);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean isWithinSafeDifference(int v1, int v2) {
        return Math.abs(v1 - v2) >= 1 && Math.abs(v1 - v2) <= 3;
    }

    public int countSafeReports(boolean useDampener) {
        int count = 0;

        for(List<Integer> levels : list) {
            if(isSafeReport(levels)) count++;
            else if(useDampener) {
                if(canBecomeSafeReport(levels)) count++;
            }
        }

        return count;
    }

    public boolean isSafeReport(List<Integer> levels) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for(int i=1; i<levels.size(); i++) {
            if(!isWithinSafeDifference(levels.get(i), levels.get(i-1))) return false;

            if(levels.get(i) > levels.get(i-1)) isDecreasing = false;
            else if(levels.get(i) < levels.get(i-1)) isIncreasing = false;
        }

        return isIncreasing || isDecreasing;
    }

    public boolean canBecomeSafeReport(List<Integer> levels) {
        for(int i=0; i<levels.size(); i++) {
            List<Integer> newLevels = new ArrayList<>();

            for(int j=0; j<levels.size(); j++) {
                if(i != j) {
                    newLevels.add(levels.get(j));
                }
            }

            if(isSafeReport(newLevels)) return true;
        }

        return false;
    }
}
