import java.io.*;
import java.util.*;

public class Solution {

	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		return r1(s, set);
	}

	private static boolean r1(String s, Set<String> set) {
		if (s.length() == 0) return true;
		for (int i = 1; i <= s.length(); i++) {
			if (set.contains(s.substring(0, i)) && r1(s.substring(i), set)) {
				return true;
			}
		}
		return false;
	}


	// iterative
	public static boolean wordBreak2(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
                        	String s = br.readLine();
				String[] ll = br.readLine().split(" ");
				List<String> wordDict = Arrays.asList(ll);
				boolean res = wordBreak2(s, wordDict);
				bw.write(Boolean.valueOf(res).toString());
				bw.newLine();	
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
