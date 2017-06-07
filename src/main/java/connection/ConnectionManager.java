package connection;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import config.Service;

public class ConnectionManager {

	private String response;
	
	public String send(String json,String endpoint) {
		try {
			HttpPost post = new HttpPost(new Service().endpoint(endpoint));
			post.setEntity(new StringEntity(json));
			post.addHeader("content-type", "application/json");
			HttpResponse test  = HttpClientBuilder.create().build().execute(post);
			response = EntityUtils.toString(test.getEntity());
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
		}
		System.out.println(response);
		return response;
	}
}
