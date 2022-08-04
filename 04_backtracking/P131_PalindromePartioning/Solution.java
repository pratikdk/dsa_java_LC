import java.io.*;
import java.util.*;

public class Solution {

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		br(res, new ArrayList<>(), s, 0);
		return res;
	}

	private static void br(List<List<String>> res, List<String> temp, String s, int start) {
		if (start == s.length()) res.add(new ArrayList<>(temp));
		else {
			for(int i = start; i < s.length(); i++) {
				if (isPalindromic(s, start, i)) {
					temp.add(s.substring(start, i+1));
					br(res, temp, s, i+1);
					temp.remove(temp.size()-1);
				}
			}
		}
	}

	private static boolean isPalindromic(String s, int l, int r) {
		while (l <= r) {
			if (s.charAt(l) != s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String s = br.readLine();
				List<List<String>> res = partition(s);
				bw.write(res.toString());
				bw.newLine();
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
