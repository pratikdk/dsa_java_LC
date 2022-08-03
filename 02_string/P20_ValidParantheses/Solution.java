import java.io.*;
import java.util.*;

public class Solution {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c: s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}

        public static void main(String[] args) {
                try (FileReader fr = new FileReader("input.txt");
                        FileWriter fw = new FileWriter("output.txt");
                        BufferedReader br = new BufferedReader(fr);
                        BufferedWriter bw = new BufferedWriter(fw)) {

                        int tt = Integer.parseInt(br.readLine());

                        while (--tt >= 0) {
				String s = br.readLine();
				boolean res = isValid(s);
				bw.write(Boolean.valueOf(res).toString());
				bw.newLine();			
                        }
                } catch(IOException e) {
                        e.printStackTrace();
                } 
        }
}
