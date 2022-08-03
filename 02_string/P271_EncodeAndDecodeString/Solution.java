import java.io.*;
import java.util.*;

public class Solution {

	public static String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s: strs) {
			sb.append(s.length() + "#" + s);
		}
		return sb.toString();
	}

	public static List<String> decode(String str) {
		List<String> res = new ArrayList<>();
		int i = 0;
		while (i < str.length()) {
			int j = i;
			while (str.charAt(j) != '#') {
				j++;
			}
			int len = Integer.parseInt(str.substring(i, j));
			res.add(str.substring(j+1, j+1+len));
			i = j+1+len;
		}
		return res;
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String[] x  = br.readLine().split("\\s*,\\s*");
				List<String> strs = new ArrayList<>(Arrays.asList(x));
				String encodedString = encode(strs);
				List<String> strs2 = decode(encodedString);
				bw.write(strs2.toString());
				bw.newLine();		
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
