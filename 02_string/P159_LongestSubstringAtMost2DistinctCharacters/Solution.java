import java.io.*;
import java.util.*;

public class Solution {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] map = new int[128];
		int start = 0, end = 0;
		int counter = 0;
		int maxLen = 0;

		while (end < s.length()) {
			if (map[s.charAt(end++)]++ == 0) counter++;
			if (counter > 2) {
				if (map[s.charAt(start++)]-- == 1) counter--;
			}
			maxLen = Math.max(maxLen, end-start);
		}
		
		return maxLen;
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String s = br.readLine();
				int res = lengthOfLongestSubstringTwoDistinct(s);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
