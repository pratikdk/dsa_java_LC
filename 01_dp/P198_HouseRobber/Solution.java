import java.io.*;
import java.util.*;

public class Solution {

	public static int rob(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n+1];
		dp[1] = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
		}
		return dp[n];
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
				int res = rob(nums);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
