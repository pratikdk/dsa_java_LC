import java.io.*;
import java.util.*;

public class Solution {

	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
                      		String[] x = br.readLine().split("\\s*,\\s*");
				int[] coins = new int[x.length]; 
				for (int i = 0; i < x.length; i++) {
					coins[i] = Integer.parseInt(x[i]);
				}
				int amount = Integer.parseInt(br.readLine());
				int res = coinChange(coins, amount);
				bw.write(String.valueOf(res));
				bw.newLine();	
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
