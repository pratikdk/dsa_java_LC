import java.io.*;
import java.util.*;

public class Solution {

	public static String shortestCommonSupersequence(String str1, String str2) {
		String res = "";
		int i = 0, j = 0;
		String ss = lcs(str1, str2);
		for (char c: ss.toCharArray()) {
			while (str1.charAt(i) != c) {
				res += str1.charAt(i);
				i++;
			}
			while (str2.charAt(j) != c) {
				res += str2.charAt(j);	
				j++;
			}
			res += c;
			i++;
			j++;
		}
		res += str1.substring(i);
		res += str2.substring(j);

		return res;
	}

	private static String lcs(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		String[][] dp = new String[n1+1][n2+1];
		for (String[] row: dp) Arrays.fill(row, "");
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
				} else {
					dp[i][j] = dp[i][j-1].length() >= dp[i-1][j].length() ? dp[i][j-1] : dp[i-1][j];
				}
			}
		}
		return dp[n1][n2];
	}
		
        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String str1 = br.readLine();
				String str2 = br.readLine();
				String res = shortestCommonSupersequence(str1, str2);
				bw.write(res);
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
