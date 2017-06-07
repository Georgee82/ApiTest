package test.registration;
import static org.junit.Assert.assertTrue;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import config.Service;
import connection.ConnectionManager;
import markup.request.Registration;
import markup.request.UserAddress;
import markup.response.Response;

public class RegistrationBusinessLogicTest {
	
	private String EMAIL = "auto2@test.lv";//TODO needs to be adjusted manually
	private String PHONE = "+37112345678";
	private String PWD = "TestPassword";
	private String BIRTH_DATE = "1999-06-03T00:00:00.000Z";
	private String DESCRIPTION = "TestDescription";
	private String COUNTRY = "TestCountry";
	private String CITY = "TestCity";
	private String STATE = "TestState";
	private String ZIP = "TestZip";
	private String STREET = "TestStreet";
	
	ObjectMapper mapper = new ObjectMapper();
	
	private Response sendPOST(Registration formUsrData, String endpoint) throws Exception {
		System.out.println(mapper.writeValueAsString(formUsrData));
		return mapper.readValue(new ConnectionManager().send(mapper.writeValueAsString(formUsrData),endpoint),
				Response.class);
	}
	
	@Test
	public void succesfullRegistration() throws Exception
	{
		UserAddress formUserAddress = new UserAddress();
		Registration formUsrData = new Registration(formUserAddress);
		
		formUsrData.setEmail(EMAIL);
		formUsrData.setPhone(PHONE);
		formUsrData.setPwd(PWD);
		formUsrData.setBirthDate(BIRTH_DATE);
		formUsrData.setDescription(DESCRIPTION);		
		
		formUserAddress.setCountry(COUNTRY);
		formUserAddress.setCity(CITY);
		formUserAddress.setState(STATE);
		formUserAddress.setZip(ZIP);
		formUserAddress.setStreet(STREET);
		
		Response response = sendPOST(formUsrData,Service.REGISTER);
		
		assertTrue(response.getResult().equals("true") && response.getDetails().equals("none"));
	}
	
}
