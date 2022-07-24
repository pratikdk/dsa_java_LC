import java.io.*;
import java.util.*;

// Maximum Subarray
public class Solution {

	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int cSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (cSum < 0) {
				cSum = 0;
			}
			cSum += nums[i];
			max = Math.max(max, cSum);
		}
		return max;
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
				//System.out.println(Arrays.toString(nums));
				int res = maxSubArray(nums);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
