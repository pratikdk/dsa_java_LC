import java.io.*;
import java.util.*;

public class Solution {

	public static int maxProduct(int[] nums) {
		int res = nums[0];
		for (int i = 1, cmax = res, cmin = res; i < nums.length; i++) {
			if (nums[i] < 0) {
				int temp = cmax;
				cmax = cmin;
				cmin = temp;
			}

			cmax = Math.max(nums[i], cmax*nums[i]);
			cmin = Math.min(nums[i], cmin*nums[i]);

			res = Math.max(res, cmax);
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
 				String[] x = br.readLine().split(" ");
	 			int[] nums = new int[x.length];
				for (int i = 0; i < x.length; i++) {
					nums[i] = Integer.parseInt(x[i]);
				}
				int res = maxProduct(nums);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
