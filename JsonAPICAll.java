package WebServiceTestingFramework;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.misc.BASE64Encoder;

@SuppressWarnings("deprecation")
public class JsonAPICAll {

	public static String postrequest(String request, String TestCaseNo) {
		String xml2String = null;
		try {
			ReadPropertyFile obj=new ReadPropertyFile();
			String[] values=obj.getPropValues();
			String name=values[0];
			String password=values[1];
			String endpointurl=values[2];
			String media_contenttype=values[3];
			String media_contenttype_value=values[4];
			String media_accept = values[5];
			String media_accept_value= values[6];
			HttpClient client = new DefaultHttpClient();
			StringEntity input = new StringEntity(request);
			System.out.println(request);
			HttpPost post = new HttpPost(endpointurl);
			//post.addHeader("Content-Type", "application/json");
			post.addHeader(media_contenttype, media_contenttype_value);
			post.addHeader(media_accept, media_accept_value);
			//post.addHeader("Accept", "application/json");
			post.setEntity(input);
			//String name = "ICW_CONFIG_NXTGE.gen";
			//String password = "C0nf1gUser";
			String authString = name + ":" + password;
			String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
			// System.out.println("Base64 encoded auth string: " +
			// authStringEnc);
			post.addHeader("Authorization", "Basic " + authStringEnc);
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
			response.getEntity().getContent()));
			String line = "";
			StringBuilder sb = new StringBuilder();
			System.out.println(response.getStatusLine());
			while ((line = rd.readLine()) != null) {

				System.out.println(line);
				sb.append(line).append("\n");
			}
			xml2String = sb.toString();
			FileWriter.filewrite(xml2String, TestCaseNo);
			// System.out.println("XML to String using BufferedReader : ");
			// System.out.println(xml2String);
			rd.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return xml2String;
	}
}