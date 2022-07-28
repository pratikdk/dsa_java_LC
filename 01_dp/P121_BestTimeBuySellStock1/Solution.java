import java.io.*;
import java.util.*;

public class Solution {

	public static int maxProfit(int[] prices) {
		int currMax = 0, max = 0;
		for (int i = 1; i < prices.length; i++) {
			currMax = Math.max(0, currMax += prices[i] - prices[i-1]);
			max = Math.max(max, currMax);
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
				int[] prices = new int[x.length];
				for (int i = 0; i < x.length; i++) {
					prices[i] = Integer.parseInt(x[i]);
				}
				int res = maxProfit(prices);
				bw.write(String.valueOf(res));
				bw.newLine();	
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
