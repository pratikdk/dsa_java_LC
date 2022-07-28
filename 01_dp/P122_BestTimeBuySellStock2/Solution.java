import java.io.*;
import java.util.*;

public class Solution {

	public static int maxProfit(int[] prices) {
		int currHold = Integer.MIN_VALUE, currNotHold = 0;

		for (int i = 0; i < prices.length; i++) {
			int prevHold = currHold, prevNotHold = currNotHold;

			currHold = Math.max(prevHold, prevNotHold - prices[i]);
			currNotHold = Math.max(prevNotHold, prevHold + prices[i]);
		}

		return currNotHold;
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
