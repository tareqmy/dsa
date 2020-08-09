package interview.leetcode;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by tareqmy on 6/8/20.
 */
public class OddCellsMatrix {


    private static void print2dArray(int[][] matrix) {
        for (int[] row : matrix)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    public static int oddCells(int n, int m, int[][] indices) {
        if (n <= 0 || m <= 0 || indices == null || indices.length <= 0) return 0;
        int[][] matrix = new int[n][m];
        int oddCount = 0;
        int x, y;
        for (int[] index : indices) {
            System.out.println(Arrays.toString(index));
            x = index[0];
            y = index[1];
            for (int j = 0; j < m; j++) {
                if (matrix[x][j] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }
                matrix[x][j] += 1;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[j][y] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }
                matrix[j][y] += 1;
            }
            print2dArray(matrix);
        }
        return oddCount;
    }

    public static void main(String[] args) {
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println("oddCells(2,3,indices) = " + oddCells(2, 3, indices));
    }

    //apparently not the best solution yet!
    public static int oddCellsLC(int n, int m, int[][] indices) {
        BitSet oddRows = new BitSet(n), oddCols = new BitSet(m);
        int cntRow = 0, cntCol = 0;
        for (int[] idx : indices) {
            oddRows.flip(idx[0]);
            oddCols.flip(idx[1]);
            cntRow += oddRows.get(idx[0]) ? 1 : -1;
            cntCol += oddCols.get(idx[1]) ? 1 : -1;
        }
        return (m - cntCol) * cntRow + (n - cntRow) * cntCol;
    }
}
