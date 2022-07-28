import java.io.*;
import java.util.*;

public class Solution {
	
	public static int maxProfit(int[] prices) {
		int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
		int notHold1 = 0, notHold2 = 0;
		
		for (int i = 0; i < prices.length; i++) {
			notHold2 = Math.max(notHold2, hold2 + prices[i]);
			hold2 = Math.max(hold2, notHold1 - prices[i]);
			notHold1 = Math.max(notHold1, hold1 + prices[i]);
			hold1 = Math.max(hold1, -prices[i]);
		}

		return notHold2;
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
