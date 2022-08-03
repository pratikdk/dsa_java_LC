import java.io.*;
import java.util.*;

public class Solution {

	// Using int array
	public static int characterReplacement(String s, int k) {
		int[] map = new int[26];
		int start = 0, end = 0;
		int maxLen = 0;

		while (end < s.length()) {
			map[s.charAt(end++) - 'A']++;

			while ((end - start) - maxInArray(map) > k) {
				map[s.charAt(start++) - 'A']--;
			}

			maxLen = Math.max(maxLen, end-start);
		}

		return maxLen;
	}

	private static int maxInArray(int[] map) {
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			max = Math.max(max, map[i]);
		}
		return max;
	}
	

	// Using Map
	public static int characterReplacement2(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0;
		int maxLen = 0;

		while (end < s.length()) {
			char c = s.charAt(end++);
			map.put(c, map.getOrDefault(c, 0) + 1);

			while ((end-start) - maxInMap(map) > k) {
				char h = s.charAt(start++);
				map.put(h, map.get(h) - 1);
				if (map.get(h) == 0) map.remove(h);
			}
			
			maxLen = Math.max(maxLen, end-start);
		}
		
		return maxLen;
	}

	private static int maxInMap(Map<Character, Integer> map) {
		int max = 0;
		for (Map.Entry<Character, Integer> entry: map.entrySet()) {
			max = Math.max(max, entry.getValue());
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
				int k = Integer.parseInt(br.readLine());
				int res = characterReplacement(s, k);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
