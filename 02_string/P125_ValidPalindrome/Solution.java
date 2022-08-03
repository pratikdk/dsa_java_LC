import java.io.*;
import java.util.*;

public class Solution {

	public static boolean isPalindrome(String s) {
		int l = 0, r = s.length()-1;
		while (l <= r) {
			if (!Character.isLetterOrDigit(s.charAt(l))) {
				l++;
			} else if (!Character.isLetterOrDigit(s.charAt(r))) {
				r--;
			} else {
				if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
					return false;
				}
				l++;
				r--;
			}
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
				boolean res = isPalindrome(s);
				bw.write(Boolean.valueOf(res).toString());
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
