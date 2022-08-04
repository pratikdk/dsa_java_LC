import java.io.*;
import java.util.*;

public class Solution {

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			if (nums[index] < 0) {
				res.add(index+1);
			}
			nums[index] = -1 * Math.abs(nums[index]);
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
				for (int i = 0; i < nums.length; i++) {
					nums[i] = Integer.parseInt(x[i]);
				}
				List<Integer> res = findDuplicates(nums);
				bw.write(res.toString());
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
