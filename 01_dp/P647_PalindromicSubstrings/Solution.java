// Palindromic Substrings
import java.io.*;
import java.util.*;

public class Solution {

	public static int countSubstrings(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			count += extendPalindrome(s, i, i);
			count += extendPalindrome(s, i, i+1);
		}
		
		return count;
	}

	private static int extendPalindrome(String s, int l, int r) {
		int icount = 0;

		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
			icount++;
		}

		return icount;
	}

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("input.txt");
			FileWriter fw = new FileWriter("output.txt");
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw)) {

			int tt = Integer.parseInt(br.readLine());

			while (--tt >= 0) {
				String s = br.readLine();
				int res = countSubstrings(s);
				System.out.println(res);
				bw.write(String.valueOf(res));
				bw.newLine();		
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
