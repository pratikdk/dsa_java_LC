import java.io.*;
import java.util.*;

public class Solution {
	
	// dp
	public static boolean canParition(int[] nums) {
		int sum = 0;
		for (int num: nums) {
			sum += num;
		}
		if ((sum & 1) == 1) {
			return false;
		}
		int targetSum = sum / 2;

		int n = nums.length;
		boolean[][] dp = new boolean[n+1][targetSum+1]; // can also use 1 row instead
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], false);
		}
		
		dp[0][0] = true;
		
		for (int i = 1; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int j = 1; j <= targetSum; j++) {
			dp[0][j] = false;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= targetSum; j++) {
				dp[i][j] = dp[i-1][j];
				if (nums[i-1] <= j) {
					dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
				}
			}
		}

		return dp[n][targetSum];
	}


	// backtrack
	public static boolean canParition2(int[] nums) {
		int sum = 0;
		for (int num: nums) {
			sum += num;
		}
		if ((sum % 2) != 0) {
			return false;
		}
		int targetSum = sum / 2;

		return br(nums, 0, 0, targetSum);
	}

	private static boolean br(int[] nums, int index, int currSum, int targetSum) {
		if (currSum == targetSum) return true;
		if (currSum > targetSum || index >= nums.length) return false;	
		
		return br(nums, index+1, currSum + nums[index], targetSum) || br(nums, index+1, currSum, targetSum);
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
				for (int i = 0; i < x.length; i++) {
					nums[i] = Integer.parseInt(x[i]);
				}
				boolean res = canParition2(nums);
				bw.write(Boolean.valueOf(res).toString());
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
