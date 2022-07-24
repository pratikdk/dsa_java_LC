// Longest palindrome substring

public class Solution {
	
	public static String longestPalindrome(String s) {
		int start = 0, max = 0;

		for (int i = 0; i < s.length(); i++) {
			int curr;		
			curr = extendPalindrome(s, i, i);
			curr = Math.max(curr, extendPalindrome(s, i, i+1));

			if (max < curr) {
				start = i - ((curr-1)/2);
				max = curr;
			}				
		}
		return s.substring(start, start+max);
	}

	private static int extendPalindrome(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r-l-1;
	}	
		
	public static void main(String[] args) {
		String[] ll = {
			"babad",
			"cbbd"
		};
		for (String s: ll) {
			System.out.println(longestPalindrome(s));
		}
	}
}	
