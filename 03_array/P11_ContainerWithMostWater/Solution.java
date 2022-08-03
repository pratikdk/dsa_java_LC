import java.io.*;
import java.util.*;

public class Solution {

	public static int maxArea(int[] height) {
		int max = 0;
		int l = 0, r = height.length-1;

		while (l < r) {
			int currArea = 0;

			if (height[l] <= height[r]) {
				currArea = (r-l) * height[l];
				l++;
			} else {
				currArea = (r-l) * height[r];
				r--;
			}

			max = Math.max(max, currArea);
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
				int[] height = new int[x.length];
				for (int i = 0; i < x.length; i++) {
					height[i] = Integer.parseInt(x[i]);
				}
				int res = maxArea(height);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
