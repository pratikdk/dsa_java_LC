import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String[] args) {
		String s = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

			s = reader.readLine();
			//writer.write(s); // closes the standard output, rather just output to system.out
			System.out.println(s);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// File read
		
		try (FileReader fr = new FileReader("input.txt")) {
			BufferedReader br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// File write
		
		try (FileWriter fw = new FileWriter("output.txt")) {
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(s + '\n');
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}	
	}
}
