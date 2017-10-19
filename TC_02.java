package WebServiceTestingFramework;

public class TC_02 {

	public static String Validate() {
		String filename = null;
		String testcaseno="TC002";
		filename = "C:/Automation/RequestJson.txt";
		String request = FileReader.filereader(filename);
		String  response = JsonAPICAll.postrequest(request,testcaseno);
		try {

			boolean val = response
					.contains("SKU Not found  or Invalid SKU");
			if (val) {
				System.out.println(testcaseno +"--->" + "Pass");
			} else {
				System.out.println(testcaseno + "---->" + "Fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
}