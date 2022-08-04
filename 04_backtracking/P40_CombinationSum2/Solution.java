import java.io.*;
import java.util.*;

public class Solution {

        public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
                List<List<Integer>> res = new ArrayList<>();
                br(res, new ArrayList<>(), candidates, target, 0);
                return res;
        }

        private static void br(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
                if (target < 0) return;
                else if (target == 0) res.add(new ArrayList<>(temp));
                else {
                        for (int i = start; i < candidates.length; i++) {
				if (i > start && candidates[i] == candidates[i-1]) continue;
                                temp.add(candidates[i]);
                                br(res, temp, candidates, target-candidates[i], i+1);
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
                                int[] candidates = new int[x.length];
                                for (int i = 0; i < x.length; i++) {
                                        candidates[i] = Integer.parseInt(x[i]);
                                }
                                int target = Integer.parseInt(br.readLine());
                                List<List<Integer>> res = combinationSum2(candidates, target);
                                bw.write(res.toString());
                                bw.newLine();
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                }
        }
}
