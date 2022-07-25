import java.io.*;
import java.util.*;

public class Solution {

	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int e = 0; // length
		for (int i = 0; i < nums.length; i++) {
			int p = Arrays.binarySearch(dp, 0, e, nums[i]);
			if (p < 0) {
				p = -(p + 1);
			}
			dp[p] = nums[i];
			if (p == e) e++;
		}
		return e;
	}

	public static int lengthOfLIS2(int[] nums) {
		int[] dp = new int[nums.length];
		int e = 0; // length
		for (int i = 0; i < nums.length; i++) {
			int l = 0, r = e;
			while (l < r) {
				int mid = (l + r) / 2;
				if (dp[mid] < nums[i]) {
					l = mid + 1;
				} else {
					r = mid;
				}
			}
			dp[l] = nums[i]; // l == r
			if (l == e) e++;
		}
		return e;
	}
		

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
                        	String[] x = br.readLine().split(" ");
				int[] nums = new int[x.length];
				for (int i = 0; i < x.length; i++) {
					nums[i] = Integer.parseInt(x[i]);
				}
				int res = lengthOfLIS2(nums);
				bw.write(String.valueOf(res));
				bw.newLine();
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
