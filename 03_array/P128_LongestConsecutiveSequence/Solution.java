import java.io.*;
import java.util.*;

public class Solution { 

	public static int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		int max = 0, curr = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i-1]) {
				if (nums[i] - nums[i-1] == 1) {
					curr += 1;
				} else {
					max = Math.max(max, curr);
					curr = 1;
				}
			}
		}
		return Math.max(max, curr);
	}

	public static int longestConsecutive2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num: nums) set.add(num);

		int max = 0;
		for (Integer num: set) {
			if (!set.contains(num-1)) {
				Integer currNum = num;
				int currLen = 1;

				while (set.contains(currNum+1)) {
					currNum++;
					currLen++;
				}

				max = Math.max(max, currLen);
			}
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
				String[] x = br.readLine().split("\\s*,\\s*");
				int[] nums = new int[x.length];
				for (int i = 0; i < x.length; i++) {
					nums[i] = Integer.parseInt(x[i]);
				}
				int res = longestConsecutive2(nums);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
