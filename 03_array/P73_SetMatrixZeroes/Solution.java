import java.io.*;
import java.util.*;

public class Solution {

	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int zeroCol = 1;

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) zeroCol = 0;
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = m-1; i >= 0; i--) {
			for (int j = n-1; j > 0; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (zeroCol == 0) matrix[i][0] = 0;
		}
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
                                String[] x = br.readLine().split(" ");
                                int m = Integer.parseInt(x[0]);
                                int n = Integer.parseInt(x[1]);
                                int[][] matrix = new int[m][n];
                                for (int i = 0; i < m; i++) {
                                        String[] y = br.readLine().split("\\s*,\\s*");
                                        for (int j = 0; j < y.length; j++) {
                                                matrix[i][j] = Integer.parseInt(y[j]);
                                        }
                                }
				setZeroes(matrix);
				bw.write(Arrays.deepToString(matrix));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
