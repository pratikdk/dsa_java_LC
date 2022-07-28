import java.io.*;
import java.util.*;

public class Solution {

	public static int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (k >= n/2) return quickSolve(prices);
		
		int[][] notHold = new int[k+1][n];
		for (int i = 1; i <= k; i++) {
			int hold = -prices[0];
			for (int j = 1; j < n; j++) {
				notHold[i][j] = Math.max(notHold[i][j-1], hold + prices[j]);
				hold = Math.max(hold, notHold[i-1][j-1] - prices[j]);
			}
		}
		
		return notHold[k][n-1];		
	}

	private static int quickSolve(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
		}
		return profit;
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
				int k = Integer.parseInt(br.readLine());
				int res = maxProfit(k, prices);
				bw.write(String.valueOf(res));
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
