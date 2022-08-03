import java.io.*;
import java.util.*;

public class Solution {
	
	// dp
	public static int lengthOfLongestSubstring(String s) {
		int[] map = new int[128];
		int start = 0, end = 0;
		int counter = 0;
		int maxSize = 0;

		while (end < s.length()) {
			if (map[s.charAt(end++)]++ > 0) counter++;
			while (counter > 0) {
				if (map[s.charAt(start++)]-- == 2) counter--;
			}
			maxSize = Math.max(maxSize, end-start);
		}
		
		return maxSize;
	}	

	// dp 2 (less eff than dp1)	
	public static int lengthOfLongestSubstring2(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				j = Math.max(j, map.get(c)+1);
			}
			max = Math.max(max, i-j+1);
			map.put(c, i);
		}
		return max;
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String s = br.readLine();
				int res = lengthOfLongestSubstring(s);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
