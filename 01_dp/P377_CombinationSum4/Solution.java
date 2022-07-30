import java.io.*;
import java.util.*;

public class Solution {

	public static int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target+1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] <= i) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}
		return dp[target];
	}
	
	// recursive
	public static int combinationSum4_2(int[] nums, int target) {
		if (target == 0) return 1;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= target) {
				res += combinationSum4_2(nums, target - nums[i]);
			}
		}
		return res;
	}

	// recursive + dp
	public static int combinationSum4_3(int[] nums, int target) {
		int[] dp = new int[target+1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		return r(nums, target, dp);
	}

	private static int r(int[] nums, int target, int[] dp) {
		if (dp[target] != -1) return dp[target];
		dp[target] = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= target) {
				dp[target] += r(nums, target - nums[i], dp);
			}
		}
		return dp[target];
	}


        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
                       		String[] x = br.readLine().split("\\s*,\\s*");
				int[] nums = new int[x.length];
				for (int i = 0; i < nums.length; i++) {
					nums[i] = Integer.parseInt(x[i]);
				}
				int target = Integer.parseInt(br.readLine());
				int res = combinationSum4(nums, target);
				bw.write(String.valueOf(res));
				bw.newLine();	
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
