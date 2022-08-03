import java.io.*;
import java.util.*;

public class Solution {

	public static boolean isAnagram(String s, String t) {
		int[] map = new int[128];
		int end = 0;

		int counter = t.length();
		for (int i = 0; i < t.length(); i++) {
			map[t.charAt(i)]++;
		}

		while (end < s.length()) {
			if (map[s.charAt(end++)]-- > 0) {
				counter--;
			} else {
				return false;
			}
		}

		return counter == 0;
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
				boolean res = isAnagram(s, t);
				bw.write(Boolean.valueOf(res).toString());
				bw.newLine();				
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
