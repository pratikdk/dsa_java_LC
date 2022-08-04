import java.io.*;
import java.util.*;

public class Solution {

	public static int[][] construct2DArray(int[] original, int m, int n) {
		if (m*n != original.length) return new int[0][0];
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = original[(i*n) + j];
			}
		}
		return matrix;
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String[] x = br.readLine().split("\\s*,\\s*");
				int[] original = new int[x.length];
				for (int i = 0; i < x.length; i++) {
					original[i] = Integer.parseInt(x[i]);
				}
				int m = Integer.parseInt(br.readLine());
				int n = Integer.parseInt(br.readLine());
				int[][] res = construct2DArray(original, m, n);
				bw.write(Arrays.deepToString(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
