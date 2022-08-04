import java.io.*;
import java.util.*;

public class Solution {

	public static int[] productExceptSelf(int[] nums) {
		int[] answer = new int[nums.length];
		Arrays.fill(answer, 1);
		int nx = nums.length-1;
		int lv = 1, rv = 1;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0) {
				answer[i] *= lv;
				answer[nx-i] *= rv;
			}
			lv *= nums[i];
			rv *= nums[nx-i];
		}
		return answer;
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
				int[] res = productExceptSelf(nums);
				bw.write(Arrays.toString(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
