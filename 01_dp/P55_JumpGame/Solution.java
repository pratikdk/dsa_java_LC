import java.io.*;
import java.util.*;

public class Solution {

	public static boolean canJump(int[] nums) {
		int i = 0;
		for (int reach = 0; i < nums.length && i <= reach; i++) {
			reach = Math.max(reach, i+nums[i]);
		}
		return i >= nums.length;
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
				boolean res = canJump(nums);
				bw.write(Boolean.valueOf(res).toString());
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
