import java.io.*;
import java.util.*;

public class Solution {

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		Arrays.fill(dp[0], 1);

		for (int i = 1; i < m; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m-1][n-1];
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
				System.out.println(m + " " + n);
				int res = uniquePaths(m, n);
				bw.write(String.valueOf(res));
				bw.newLine();
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
