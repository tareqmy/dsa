package interview.amazon_interview_questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tareqmy on 29/7/20.
 */
public class NumberOfIslands {

    //Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    // An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    // You may assume all four edges of the grid are all surrounded by water.

    public static int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
            for (int j = 0; j < grid[i].length; j++) {
                System.out.println(i + " " + j);
                char c = grid[i][j];
                System.out.println(c);
                if (c == '1') {
                    int north = i - 1;
                    int south = i + 1;
                    int west = j - 1;
                    int east = j + 1;
                    if ((0 <= north && north < grid.length) && grid[north][j] == '1') {
                        System.out.println("land on north");
                    }
                    if ((0 <= south && south < grid.length) && grid[south][j] == '1') {
                        System.out.println("land on south");
                    }
                    if (0 <= west && west < grid[i].length && grid[i][west] == '1') {
                        System.out.println("land on west");
                    }
                    if (0 <= east && east < grid[i].length && grid[i][east] == '1') {
                        System.out.println("land on east");
                    }
                }
            }
            System.out.println();
        }
        return islandCount;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int count = numIslandsLC(grid);
        System.out.println("count = " + count);
    }

    //could not find my way on my own... so go check the discuss board.
    public static int numIslandsLC(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited.contains(i + "" + j)) {
                    continue;
                }
                if (grid[i][j] == '1') { //We found a new island, lets scout it and count it!
                    scoutIsland(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void scoutIsland(char[][] grid, int i, int j, Set<String> visited) {
        if (visited.contains(i + "" + j) || i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        visited.add(i + "" + j);
        scoutIsland(grid, i + 1, j, visited); //Scouting the island in all 4 directions
        scoutIsland(grid, i, j + 1, visited);
        scoutIsland(grid, i - 1, j, visited);
        scoutIsland(grid, i, j - 1, visited);
    }
}