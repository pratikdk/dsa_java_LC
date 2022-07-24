import java.io.*;
import java.util.*;

public class Solution {
	
	public static int climbStairs(int n) {
		if (n <= 0) return 0;
		int a = 1;
		int b = 2;
		if (n == 1) return a;
		if (n == 2) return b;
		int sum;
		for (int i = 3; i <= n; i++) {
			sum = a + b;
			a = b; 
			b = sum;
		}
		return b;
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
                        	int n = Integer.parseInt(br.readLine());
				int res = climbStairs(n);
				bw.write(String.valueOf(res));
				bw.newLine();
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
