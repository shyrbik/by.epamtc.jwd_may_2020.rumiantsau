package by.it.akhmelev.jd01_02;

public class TaskC {

    static int[][] step3(int[][] m) {
        boolean[] delCol = new boolean[m[0].length];
        boolean[] delRow = new boolean[m.length];
        int max = Integer.MIN_VALUE;
        for (int[] row : m) {
            for (int e : row) {
                if (max < e) max = e;
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }

        int cols = 0;
        for (boolean b : delCol) if (!b) cols++;
        int rows = 0;
        for (boolean b : delRow) if (!b) rows++;

        int[][] res = new int[rows][cols];
        int ir = 0;
        for (int i = 0; i < m.length; i++) {
            if (!delRow[i]) {
                int jr = 0;
                for (int j = 0; j < m[i].length; j++) {
                    if (!delCol[j]) {
                        res[ir][jr++] = m[i][j];
                    }
                }
                ir++;
            }
        }
        return res;

    }
}
