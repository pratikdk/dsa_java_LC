import java.io.*;
import java.util.*;

public class Solution {

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s: strs) {
			char[] cc = s.toCharArray();
			Arrays.sort(cc);
			String sKey = String.valueOf(cc);
			map.putIfAbsent(sKey, new ArrayList<>());
			map.get(sKey).add(s);
		}
		return new ArrayList<>(map.values()); // return a copy
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String[] strs = br.readLine().split("\\s*,\\s*");
				List<List<String>> res = groupAnagrams(strs);
				bw.write(res.toString());
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
