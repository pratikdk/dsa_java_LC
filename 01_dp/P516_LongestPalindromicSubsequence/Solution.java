import java.io.*;
import java.util.*;

public class Solution {

	public static int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = n-1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i+1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i+1][j-1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
				}
			}
		}
		return dp[0][n-1];
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String s = br.readLine();
				int res = longestPalindromeSubseq(s);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
