import java.io.*;
import java.util.*;

public class Solution {

	static class NumArray {
		private int[] nums;

		public NumArray(int[] nums) {
			for (int i = 1; i < nums.length; i++) {
				nums[i] = nums[i] + nums[i-1];
			}
			this.nums = nums;
		}

		public int sumRange(int left, int right) {
			if (left == 0) {
				return nums[right];
			}
			return nums[right] - nums[left-1];
		}
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
				NumArray numArray = new NumArray(nums);

				int o = Integer.parseInt(br.readLine());
				for (int i = 0; i < o; i++) {
					String[] y = br.readLine().split(" ");
					int left = Integer.parseInt(y[0]);
					int right = Integer.parseInt(y[1]);
					int res = numArray.sumRange(left, right);
					bw.write(String.valueOf(res));
					bw.newLine();
				}	
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
