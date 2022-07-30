import java.io.*;
import java.util.*;

public class Solution {
	
	public static List<List<Integer>> combinationSum3(int k, int n) { // n is target
		List<List<Integer>> res = new ArrayList<>();
		btr(res, new ArrayList<>(), k, n, 1);
		return res;
	}

	private static void btr(List<List<Integer>> res, List<Integer> temp, int k, int n, int start) {
		if (temp.size() > k) return;
		
		if (temp.size() == k && n == 0) {
			res.add(new ArrayList<>(temp));
	     	}
  		
		for (int i = start; i <= 9; i++) {
			temp.add(i);
			btr(res, temp, k, n-i, i+1);
			temp.remove(temp.size() - 1);
		}
	}
	
        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String[] x = br.readLine().split(" ");
				int k = Integer.parseInt(x[0]);
				int n = Integer.parseInt(x[1]);
				List<List<Integer>> res = combinationSum3(k, n);
				bw.write(res.toString());
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
