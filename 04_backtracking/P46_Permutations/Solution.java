import java.io.*;
import java.util.*;

public class Solution {

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		br(res, new ArrayList<>(), nums, visited);
		return res;
	}

	private static void br(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] visited) {
		if (temp.size() == nums.length) res.add(new ArrayList<>(temp));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (visited[i]) continue;
				visited[i] = true;
				temp.add(nums[i]);
				br(res, temp, nums, visited);
				visited[i] = false;
				temp.remove(temp.size()-1);
			}
		}
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
				List<List<Integer>> res = permute(nums);
				bw.write(res.toString());
				bw.newLine();
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
