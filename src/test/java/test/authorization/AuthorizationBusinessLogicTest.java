package test.authorization;
import static org.junit.Assert.assertTrue;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import config.Service;
import connection.ConnectionManager;
import markup.request.Authorization;
import markup.response.Response;

public class AuthorizationBusinessLogicTest {

	ObjectMapper mapper = new ObjectMapper();

	private Response sendPOST(Authorization formUsrData, String endpoint) throws Exception {
		System.out.println(mapper.writeValueAsString(formUsrData));
		return mapper.readValue(new ConnectionManager().send(mapper.writeValueAsString(formUsrData),endpoint),
				Response.class);
	}
	
	private String CORRECT_LOGIN = "auto1@test.lv";
	private String CORRECT_PASSWORD = "TestPassword";
	private String WRONG_LOGIN = "WrongLogin";
	private String WRONG_PASSWORD = "WrongPassword";
	
	@Test
	public void succefullAuthorization() throws Exception {
		
		Authorization authorizationForm = new Authorization();

		authorizationForm.setLogin(CORRECT_LOGIN);
		authorizationForm.setPwd(CORRECT_PASSWORD);

		Response response = sendPOST(authorizationForm,Service.AUTHORIZE);

		assertTrue(response.getResult().equals("true") && response.getDetails().equals("AAABBBCCCDDDEEE=="));
	}

	@Test
	public void userNotRegistered() throws Exception {
		
		Authorization authorizationForm = new Authorization();

		authorizationForm.setLogin(WRONG_LOGIN);
		authorizationForm.setPwd(WRONG_PASSWORD);

		Response response = sendPOST(authorizationForm,Service.AUTHORIZE);

		assertTrue(response.getResult().equals("0") && response.getDetails().equals("User does not exists"));
	}

	@Test
	public void wrongPassword() throws Exception {
		
		Authorization authorizationForm = new Authorization();
		
		authorizationForm.setLogin(CORRECT_LOGIN);
		authorizationForm.setPwd(WRONG_PASSWORD);

		Response response = sendPOST(authorizationForm,Service.AUTHORIZE);

		assertTrue(response.getResult().equals("0") && response.getDetails().equals("Failed to authorize"));
	}

	@Test
	public void wrongLogin() throws Exception {
		
		Authorization authorizationForm = new Authorization();
		
		authorizationForm.setLogin(WRONG_LOGIN);
		authorizationForm.setPwd(CORRECT_PASSWORD);

		Response response = sendPOST(authorizationForm,Service.AUTHORIZE);

		assertTrue(response.getResult().equals("0") && response.getDetails().equals("User does not exists"));
	}
}