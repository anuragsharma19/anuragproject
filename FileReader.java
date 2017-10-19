package WebServiceTestingFramework;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReader {

	public static String filereader(String files) {
		String requestxml = null;
		try {

			FileInputStream fstream = new FileInputStream(files);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			StringBuilder sb1 = new StringBuilder();
			while ((strLine = br.readLine()) != null) {
				sb1.append(strLine).append("\n");
			}
			requestxml = sb1.toString();

		} catch (Exception e)

		{
			e.printStackTrace();
		}
		return requestxml;
	}

}