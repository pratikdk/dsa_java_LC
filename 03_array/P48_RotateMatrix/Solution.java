import java.io.*;
import java.util.*;

public class Solution {

	public static void rotate(int[][] matrix) {
		int nx = matrix.length-1;
		for (int i = 0; i < matrix.length/2; i++) {
			for (int j = i; j < nx-i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[nx-j][i];
				matrix[nx-j][i] = matrix[nx-i][nx-j];
				matrix[nx-i][nx-j] = matrix[j][nx-i];
				matrix[j][nx-i] = temp;
			}
		}
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				int n = Integer.parseInt(br.readLine());
				int[][] matrix = new int[n][n];
				for (int i = 0; i < matrix.length; i++) {
					String[] x = br.readLine().split("\\s*,\\s*");
					for (int j = 0; j < n; j++) {
						matrix[i][j] = Integer.parseInt(x[j]);
					}
				}
				rotate(matrix);
				bw.write(Arrays.deepToString(matrix));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
