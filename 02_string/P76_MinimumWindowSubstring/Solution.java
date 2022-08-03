import java.io.*;
import java.util.*;

public class Solution {
	public static String minWindow(String s, String t) {
		int[] map = new int[128];
		int start = 0, end = 0;
		int head = 0;
		int minLen = Integer.MAX_VALUE;

		int counter = t.length();
		for (int i = 0; i < t.length(); i++) {
			map[t.charAt(i)]++;
		}

		while (end < s.length()) {
			if (map[s.charAt(end++)]-- > 0) counter--;

			while (counter == 0) {
				if (end-start < minLen) {
					minLen = end-start;
					head = start;
				}
				if (map[s.charAt(start++)]++ == 0) counter++;
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head+minLen);
	}


        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
                       		String s = br.readLine();
				String t = br.readLine();
				String res = minWindow(s, t);
				bw.write(res);
				bw.newLine();	
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
