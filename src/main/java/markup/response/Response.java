package markup.response;
import org.codehaus.jackson.annotate.JsonProperty;

public class Response {
	
	@JsonProperty("Result")
	private String result;
	
	@JsonProperty("Details")
	private String details;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
