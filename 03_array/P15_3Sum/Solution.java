import java.io.*;
import java.util.*;

public class Solution {

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length-2; i++) {
			if (i == 0 || nums[i] != nums[i-1]) {
				int l = i+1, r = nums.length-1;
				while (l < r) {
					int sum = nums[i] + nums[l] + nums[r];
					if (sum < 0) {
						l++;
					} else if (sum > 0) {
						r--;
					} else {
						res.add(Arrays.asList(nums[i], nums[l], nums[r]));
						l++;
						r--;
						while (l < r && nums[l] == nums[l-1]) l++;
						while (l < r && nums[r] == nums[r+1]) r--;
					}
				}
			}
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
				String[] x = br.readLine().split("\\s*,\\s*");
				int[] nums = new int[x.length];
	 			for (int i = 0; i < x.length; i++) {
					nums[i] = Integer.parseInt(x[i]);
				}
				List<List<Integer>> res = threeSum(nums);
				bw.write(res.toString());
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
