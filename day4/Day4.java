package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    private List<List<Character>> grid = new ArrayList<>();
    private int count = 0;
    private char[] word = new char[]{'X', 'M', 'A', 'S'};

    public Day4() {
        readInput();
    }
    
    public void readInput() {
        try {
            File input = new File("day4/input.txt");
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                List<Character> row = new ArrayList<>();
                for(char c : sc.nextLine().toCharArray()) {
                    row.add(c);
                }
                grid.add(row);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void search() {
        int ROW = this.grid.size(), COL = this.grid.get(0).size();

        //top to bottom, left to right
        for(int r=0; r<ROW; r++) {
            for(int c=0; c<COL; c++) {
                searchTopToBottom(r, c, 0);
                searchLeftToRight(r, c, 0);
                searchDiagonalDownLeftToRight(r, c, 0);
                searchDiagonalDownRightToLeft(r, c, 0);
            }
        }

        //bottom to top, right to left
        for(int r=ROW-1; r>=0; r--) {
            for(int c=COL-1; c>=0; c--) {
                searchBottomToTop(r, c, 0);
                searchRightToLeft(r, c, 0);
                searchDiagonalUpRightToLeft(r, c, 0);
                searchDiagonalUpLeftToRight(r, c, 0);
            }
        }

        System.out.println("Total number of XMAS: " + this.count);
    }

    public void searchTopToBottom(int row, int col, int index) {
        if(row == this.grid.size() || col == this.grid.get(0).size() || row < 0 || col < 0 || index > 3) {
            return;
        }

        char cur = this.grid.get(row).get(col);
        if(cur != this.word[index]) return;
        else {
            if(cur == 'S') this.count++;
            else {
                searchTopToBottom(row+1, col, index+1);
            }
        }
    }

    public void searchLeftToRight(int row, int col, int index) {
        if(row == this.grid.size() || col == this.grid.get(0).size() || row < 0 || col < 0 || index > 3) {
            return;
        }

        char cur = this.grid.get(row).get(col);
        if(cur != this.word[index]) return;
        else {
            if(cur == 'S') this.count++;
            else {
                searchLeftToRight(row, col+1, index+1);
            }
        }
    }

    public void searchDiagonalDownLeftToRight(int row, int col, int index) {
        if(row == this.grid.size() || col == this.grid.get(0).size() || row < 0 || col < 0 || index > 3) {
            return;
        }

        char cur = this.grid.get(row).get(col);
        if(cur != this.word[index]) return;
        else {
            if(cur == 'S') this.count++;
            else {
                searchDiagonalDownLeftToRight(row+1, col+1, index+1);
            }
        }
    }

    public void searchDiagonalUpLeftToRight(int row, int col, int index) {
        if(row == this.grid.size() || col == this.grid.get(0).size() || row < 0 || col < 0 || index > 3) {
            return;
        }

        char cur = this.grid.get(row).get(col);
        if(cur != this.word[index]) return;
        else {
            if(cur == 'S') this.count++;
            else {
                searchDiagonalUpLeftToRight(row-1, col+1, index+1);
            }
        }
    }

    public void searchBottomToTop(int row, int col, int index) {
        if(row == this.grid.size() || col == this.grid.get(0).size() || row < 0 || col < 0 || index > 3) {
            return;
        }

        char cur = this.grid.get(row).get(col);
        if(cur != this.word[index]) return;
        else {
            if(cur == 'S') this.count++;
            else {
                searchBottomToTop(row-1, col, index+1);
            }
        }
    }

    public void searchRightToLeft(int row, int col, int index) {
        if(row == this.grid.size() || col == this.grid.get(0).size() || row < 0 || col < 0 || index > 3) {
            return;
        }

        char cur = this.grid.get(row).get(col);
        if(cur != this.word[index]) return;
        else {
            if(cur == 'S') this.count++;
            else {
                searchRightToLeft(row, col-1, index+1);
            }
        }
    }

    public void searchDiagonalUpRightToLeft(int row, int col, int index) {
        if(row == this.grid.size() || col == this.grid.get(0).size() || row < 0 || col < 0 || index > 3) {
            return;
        }

        char cur = this.grid.get(row).get(col);
        if(cur != this.word[index]) return;
        else {
            if(cur == 'S') this.count++;
            else {
                searchDiagonalUpRightToLeft(row-1, col-1, index+1);
            }
        }
    }

    public void searchDiagonalDownRightToLeft(int row, int col, int index) {
        if(row == this.grid.size() || col == this.grid.get(0).size() || row < 0 || col < 0 || index > 3) {
            return;
        }

        char cur = this.grid.get(row).get(col);
        if(cur != this.word[index]) return;
        else {
            if(cur == 'S') this.count++;
            else {
                searchDiagonalDownRightToLeft(row+1, col-1, index+1);
            }
        }
    }

    /** Part 2:
     * ---------
     * m s
     *  a
     * m s
     * 
     * s m
     *  a
     * s m
     * 
     * s s
     *  a
     * m m
     * 
     * m m
     *  a
     * s s
     */

    public void searchXMAS() {
        int ROW = this.grid.size(), COL = this.grid.get(0).size();

        for(int r=1; r<ROW-1; r++) {
            for(int c=1; c<COL-1; c++) {
                if(grid.get(r).get(c) == 'A') {
                    if(checkCombis(r, c)) {
                        this.count++;
                    }
                }
            }
        }

        System.out.println("Total number of X-MAS: " + this.count);
    }

    public boolean checkCombis(int row, int col) {
        char topLeft = this.grid.get(row-1).get(col-1), topRight = this.grid.get(row-1).get(col+1);
        char bottomLeft = this.grid.get(row+1).get(col-1), bottomRight = this.grid.get(row+1).get(col+1);

        if((topLeft == 'M' && topRight == 'S' && bottomLeft == 'M' && bottomRight == 'S') ||
            (topLeft == 'S' && topRight == 'M' && bottomLeft == 'S' && bottomRight == 'M') ||
            (topLeft == 'S' && topRight == 'S' && bottomLeft == 'M' && bottomRight == 'M') ||
            (topLeft == 'M' && topRight == 'M' && bottomLeft == 'S' && bottomRight == 'S')) return true;
        
        else return false;
    }

    public void printGrid() {
        for(List<Character> row : grid) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
