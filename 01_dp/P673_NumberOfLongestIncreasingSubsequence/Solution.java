import java.io.*;
import java.util.*;

public class Solution {

	public static int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int[] len = new int[n];
		int[] cnt = new int[n];
		int maxLen = 0, res = 0;

		for (int i = 0; i < n; i++) {
			len[i] = 1;
			cnt[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (len[i] == len[j] + 1) cnt[i] += cnt[j];
					if (len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
						cnt[i] = cnt[j];
					}
				}
			}
			if (maxLen == len[i]) res += cnt[i];
			if (maxLen < len[i]) {
				maxLen = len[i];
				res = cnt[i];
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
				int res = findNumberOfLIS(nums);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
