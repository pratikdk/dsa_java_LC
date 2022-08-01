import java.io.*;
import java.util.*;

public class Solution {
	
	// each subset: for each subset, put any numbers inside
	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num: nums) {
			sum += num;
		}
		if ((sum % k) != 0) return false;
		int subsetSum = sum / 2;

		Arrays.sort(nums);
		reverse(nums);

		boolean[] visited = new boolean[nums.length];

		return br(nums, visited, subsetSum, k, 0, 0);	
	}

	private static boolean br(int[] nums, boolean[] visited, int subsetSum, int k, int start, int currSum) {
		if (k == 1) {
			return true;
		}
		if (currSum == subsetSum) {
			return br(nums, visited, subsetSum, k-1, 0, 0);
		}

		for (int i = start; i < nums.length; i++) {
			if ((nums[i] + currSum) <= subsetSum) {
				visited[i] = true;
				if (br(nums, visited, subsetSum, k, i+1, currSum+nums[i])) {
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
	

	// each number: for each number, put it into any subset
	public static boolean canPartitionKSubsets2(int[] nums, int k) {
		int sum = 0;
		for (int num: nums) {
			sum += num;
		}
		if ((sum % k) != 0) return false;
		int subsetSum = sum / 2;

		Arrays.sort(nums);
		reverse(nums);

		int[] ks = new int[k];

		return br2(nums, ks, subsetSum, k, 0);
	}

	private static boolean br2(int[] nums, int[] ks, int subsetSum, int k, int j) {
		if (j == nums.length) {
			for (int i = 0; i < k; i++) {
				if (ks[i] != subsetSum) {
					return false;
				}
			}
			return true;
		}

		for (int i = 0; i < k; i++) {
			if ((ks[i] + nums[j]) <= subsetSum) {
				ks[i] += nums[j];
				if (br2(nums, ks, subsetSum, k, j + 1)) {
					return true;
				}
				ks[i] -= nums[j];
			}
		}
		return false;
	}
			       

	private static void reverse(int[] nums) {
		for (int i = 0; i < (nums.length/2); i++) {
			int temp = nums[i];
			nums[i] = nums[nums.length-1-i];
			nums[nums.length-1-i] = temp;
		}
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
				};
				int k = Integer.parseInt(br.readLine());
				boolean res = canPartitionKSubsets2(nums, k);
				bw.write(Boolean.valueOf(res).toString());
				bw.newLine();				
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
