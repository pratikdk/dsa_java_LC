import java.io.*;
import java.util.*;

public class Solution {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int left = 0, right = matrix[0].length;
		int top = 0, bottom = matrix.length;
		
		while (top < bottom && left < right) {
			for (int i = left; i < right; i++) {
				res.add(matrix[top][i]);
			}
			top++;

			for (int i = top; i < bottom; i++) {
				res.add(matrix[i][right-1]);
			}
			right--;

			if (top == bottom || left == right) {
				break;
			}

			for (int i = right-1; i >= left; i--) {
				res.add(matrix[bottom-1][i]);
			}
			bottom--;

			for (int i = bottom-1; i >= top; i--) {
				res.add(matrix[i][left]);
			}
			left++;
		}
					
		return res;
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
				List<Integer> res = spiralOrder(matrix);
				bw.write(res.toString());
				bw.newLine();		
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
