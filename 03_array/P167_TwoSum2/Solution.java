import java.io.*;
import java.util.*;

public class Solution {

	public static int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		int l = 0, r = numbers.length-1;
		while (l < r) {
			int sum = numbers[l] + numbers[r];
			if (sum < target) l++;
			else if (sum > target) r--;
			else {
				res[0] = l+1;
				res[1] = r+1;
				l++;
				r--;
				while (l < r && numbers[l] == numbers[l-1]) l++;
				while (l < r && numbers[r] == numbers[r+1]) r--;
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
				int[] numbers = new int[x.length];
				for (int i = 0; i < x.length; i++) { 
					numbers[i] = Integer.parseInt(x[i]);
				}
				int target = Integer.parseInt(br.readLine());
				int[] res = twoSum(numbers, target);
				bw.write(Arrays.toString(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
