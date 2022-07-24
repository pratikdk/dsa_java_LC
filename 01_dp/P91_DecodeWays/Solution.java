import java.io.*;
import java.util.*;

public class Solution {

	public static int numDecodings(String s) {
		if (s.length() == 0) return 0;
		return r1(s, 0);
	}

	private static int r1(String s, int p) {
		if (p == s.length()) return 1;
		if (s.charAt(p) == '0') return 0;
		int res = r1(s, p+1);
		if (p < s.length()-1 && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p+1) < '7')) {
			res += r1(s, p+2);
		}
		return res;
	}

	// version 2, recursive dp
	public static int numDecodings2(String s) {
		int len = s.length();
		if (len == 0) return 0;
		int[] dp = new int[len + 1];
		Arrays.fill(dp, -1);
		dp[len] = 1;
		return r2(s, 0, dp);
	}

	private static int r2(String s, int p, int[] dp) {
		if (dp[p] != -1) return dp[p];
		if (s.charAt(p) == '0') return dp[p] = 0;
		dp[p] = r2(s, p+1, dp);
		if (p < s.length()-1 && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p+1) < '7')) {
                        dp[p] += r2(s, p+2, dp);
                }
                return dp[p];
	}

	// version 3, iterative dp
	public static int numDecodings3(String s) {
		int len = s.length();
		int[] dp = new int[len+1];
		dp[len] = 1;
		for (int i = len-1; i >= 0; i--) {
			if (s.charAt(i) != '0') {
				dp[i] = dp[i+1];
				if (i < len-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')) {
					dp[i] += dp[i+2];
				}
			}
		}
		return dp[0];
	}	

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
                        	String s = br.readLine();
				int res = numDecodings3(s);
				bw.write(String.valueOf(res));
				bw.newLine();
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
