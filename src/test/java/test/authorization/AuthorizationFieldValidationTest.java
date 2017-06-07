package test.authorization;
import static org.junit.Assert.assertTrue;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import config.Service;
import connection.ConnectionManager;
import markup.request.Authorization;
import markup.response.Response;

public class AuthorizationFieldValidationTest {
	
	private String CORRECT_PASSWORD = "TestPassword";
	
	ObjectMapper mapper = new ObjectMapper();
	
	private Response sendPOST(Authorization formUsrData, String endpoint) throws Exception {
		System.out.println(mapper.writeValueAsString(formUsrData));
		return mapper.readValue(new ConnectionManager().send(mapper.writeValueAsString(formUsrData),endpoint),
				Response.class);
	}
	
	@Test	
	public void loginNull() throws Exception{
		
		Authorization authorizationForm = new Authorization();
		
		authorizationForm.setLogin("");
		authorizationForm.setPwd(CORRECT_PASSWORD);

		Response response = sendPOST(authorizationForm,Service.AUTHORIZE);

		assertTrue(response.getResult().equals("0") && response.getDetails().equals("Field login missed"));
	}
	
	@Test	
	public void loginSpace() throws Exception{
		
		Authorization authorizationForm = new Authorization();
		
		authorizationForm.setLogin(" ");
		authorizationForm.setPwd(CORRECT_PASSWORD);

		Response response = sendPOST(authorizationForm,Service.AUTHORIZE);

		assertTrue(response.getResult().equals("0") && response.getDetails().equals("Field login missed"));
	}
	
	@Test	
	public void loginVeryLong() throws Exception{
		
		Authorization authorizationForm = new Authorization();
		
		authorizationForm.setLogin("VeryLongStringShouldHaveBeenEnteredHereButNoTimeToFinishSorry");
		authorizationForm.setPwd(CORRECT_PASSWORD);

		Response response = sendPOST(authorizationForm,Service.AUTHORIZE);

		assertTrue(response.getResult().equals("0") && response.getDetails().equals("Field login bad format"));
	}
}
