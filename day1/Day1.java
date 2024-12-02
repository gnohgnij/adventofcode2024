package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    private List<Integer> left;
    private List<Integer> right;

    public Day1() {
        this.left = new ArrayList<>();
        this.right = new ArrayList<>();
    }

    public void readInput() {
        try {
            File input = new File("day1/input.txt");
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                String locationIds = sc.nextLine();
                String[] split = locationIds.split("   ");
                left.add(Integer.parseInt(split[0]));
                right.add(Integer.parseInt(split[1]));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sortLists() {
        Collections.sort(left);
        Collections.sort(right);
    }

    public int calculateDistance() {
        int totalDistance = 0;
        int len = left.size();

        for(int i=0; i<len; i++) {
            int leftVal = left.get(i), rightVal = right.get(i);
            int distance = Math.abs(rightVal - leftVal);
            totalDistance += distance;
        }

        return totalDistance;
    }
}