package WebServiceTestingFramework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileWriter {

	public static void filewrite(String response, String TestCaseNo) {
		try {

			Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:/Automation/ResponseJson_"
							+ TestCaseNo + ".txt"), "utf-8"));
			writer.write(response);
			// System.out.println(response);
			writer.close();
		} catch (Exception e)

		{
			e.printStackTrace();
		}

	}
}